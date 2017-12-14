通常情况下，把API直接暴露出去是风险很大的，不说别的，直接被机器攻击就喝一壶的。
那么一般来说，对API要划分出一定的权限级别，然后做一个用户的鉴权，
依据鉴权结果给予用户开放对应的API。目前，比较主流的方案有几种:

1,用户名和密码鉴权，使用Session保存用户鉴权结果。
2,使用OAuth进行鉴权（其实OAuth也是一种基于Token的鉴权，只是没有规定Token的生成方式）
3,自行采用Token进行鉴权

第一种就不介绍了，由于依赖Session来维护状态，也不太适合移动时代，新的项目就不要采用了。
第二种OAuth的方案和JWT都是基于Token的，但OAuth其实对于不做开放平台的公司有些过于复杂。
我们主要介绍第三种：JWT

什么是JWT？

JWT是 Json Web Token 的缩写。它是基于 RFC 7519 标准定义的一种可以安全传输的 
小巧 和 自包含 的JSON对象。由于数据是使用数字签名的，所以是可信任的和安全的。
JWT可以使用HMAC算法对secret进行加密或者使用RSA的公钥私钥对来进行签名。

JWT的工作流程

下面是一个JWT的工作流程图。模拟一下实际的流程是这样的（假设受保护的API在/protected中）

1,用户导航到登录页，输入用户名、密码，进行登录
2,服务器验证登录鉴权，如果改用户合法，根据用户的信息和服务器的规则生成JWT Token
3,服务器将该token以json形式返回（不一定要json形式，这里说的是一种常见的做法）
4,用户得到token，存在localStorage、cookie或其它数据存储形式中。
5,以后用户请求/protected中的API时，在请求的header中加入 Authorization: Bearer xxxx(token)。此处注意token之前有一个7字符长度的 Bearer
6,服务器端对此token进行检验，如果合法就解析其中内容，根据其拥有的权限和自己的业务逻辑给出对应的响应结果。
7,用户取得结果


JWT的生成和解析

为了简化我们的工作，这里引入一个比较成熟的JWT类库，叫 jjwt ( https://github.com/jwtk/jjwt )。
这个类库可以用于Java和Android的JWT token的生成和验证。

JWT的生成可以使用下面这样的代码完成：

http://localhost:8090/auth/register POST
{
  "username": "jiao",
  "password": "pwd",
  "email": "jiao@126.com"
}

获取token
http://localhost:8090/auth POST
{
  "username": "jiao",
  "password": "pwd"
}

{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiY3JlYXRlZCI6MTUxMzA0NjgyNzMyNywiZXhwIjoxNTEzNjUxNjI3fQ.cLViPrfqsoNZK_nY_qHoEEUR9wI-1Cc3aTIf_Sz4lxrY75o8ZD7vILwTw_ijPZWy0yxeSLtmj5Y8D0Goj6YDvw"
}
仔细看到的话还是可以看到这个token分成了三部分，每部分用 . 分隔，每段都是用 Base64 编码的。如果我们用一个Base64的解码器的话 （ https://www.base64decode.org/ ）
{
    "alg":"HS512"
}

这是告诉我们HMAC采用HS512算法对JWT进行的签名。
{"sub":"test","created":1513046827327,"exp":1513651627}

也就是说JWT是由三段组成的，按官方的叫法分别是header（头）、payload（负载）和signature（签名）header.payload.signature


http://localhost:8090/users GET

http://localhost:8090/users/?username=jiao
header 
Authorization Bearer token


Spring Security

Spring Security是一个基于Spring的通用安全框架，里面内容太多了，本文的主要目的也不是展开讲这个框架，而是如何利用Spring Security和JWT一起来完成API保护。所以关于Spring Secruity的基础内容或展开内容，请自行去官网学习（ http://projects.spring.io/spring-security/ ）。

简单的背景知识

如果你的系统有用户的概念的话，一般来说，你应该有一个用户表，最简单的用户表，应该有三列：Id，Username和Password，类似下表这种

ID	USERNAME	PASSWORD
10	wang	abcdefg
而且不是所有用户都是一种角色，比如网站管理员、供应商、财务等等，这些角色和网站的直接用户需要的权限可能是不一样的。那么我们就需要一个角色表：

ID	ROLE
10	USER
20	ADMIN
当然我们还需要一个可以将用户和角色关联起来建立映射关系的表。

USER_ID	ROLE_ID
10	10
20	20
这是典型的一个关系型数据库的用户角色的设计，由于我们要使用的MongoDB是一个文档型数据库，所以让我们重新审视一下这个结构。

这个数据结构的优点在于它避免了数据的冗余，每个表负责自己的数据，通过关联表进行关系的描述，同时也保证的数据的完整性：比如当你修改角色名称后，没有脏数据的产生。

但是这种事情在用户权限这个领域发生的频率到底有多少呢？有多少人每天不停的改的角色名称？当然如果你的业务场景确实是需要保证数据完整性，你还是应该使用关系型数据库。但如果没有高频的对于角色表的改动，其实我们是不需要这样的一个设计的。在MongoDB中我们可以将其简化为

{
  _id: <id_generated>
  username: 'user',
  password: 'pass',
  roles: ['USER', 'ADMIN']
}

Spring Security需要我们实现几个东西，第一个是UserDetails：这个接口中规定了用户的几个必须要有的方法，
所以我们创建一个JwtUser类来实现这个接口。为什么不直接使用User类？因为这个UserDetails完全是为了安全服务的，
它和我们的领域类可能有部分属性重叠，但很多的接口其实是安全定制的，所以最好新建一个类：

集成JWT和Spring Security

到现在，我们还是让JWT和Spring Security各自为战，并没有集成起来。要想要JWT在Spring中工作，我们应该新建一个filter，并把它配置在 WebSecurityConfig 中




