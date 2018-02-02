https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247484798&idx=1&sn=eb4bc589a0969afc33a82edfbdc6a44c&chksm=9bd0a8e6aca721f0768eec0b4337765572b29ba4f5c163235147c77623f91788757ac5b3d7a9&mpshare=1&scene=23&srcid=0202iKwtakrpczVzt5gt1Zn1#rd

很多时候，我们在构建系统的时候都会自己创建用户管理体系，这对于开发人员来说并不是什么难事，但是当我们需要维护多个不同系统并且相同用户跨系统使用的情况下，如果每个系统维护自己的用户信息，那么此时用户信息的同步就会变的比较麻烦，对于用户自身来说也会非常困扰，很容易出现不同系统密码不一致啊等情况出现。如果此时我们引入LDAP来集中存储用户的基本信息并提供统一的读写接口和校验机制，那么这样的问题就比较容易解决了。下面就来说说当我们使用Spring Boot开发的时候，如何来访问LDAP服务端。


LDAP简介
LDAP（轻量级目录访问协议，Lightweight Directory Access Protocol)是实现提供被称为目录服务的信息服务。目录服务是一种特殊的数据库系统，其专门针对读取，浏览和搜索操作进行了特定的优化。目录一般用来包含描述性的，基于属性的信息并支持精细复杂的过滤能力。目录一般不支持通用数据库针对大量更新操作操作需要的复杂的事务管理或回卷策略。而目录服务的更新则一般都非常简单。这种目录可以存储包括个人信息、web链结、jpeg图像等各种信息。为了访问存储在目录中的信息，就需要使用运行在TCP/IP 之上的访问协议—LDAP。

LDAP目录中的信息是是按照树型结构组织，具体信息存储在条目(entry)的数据结构中。条目相当于关系数据库中表的记录；条目是具有区别名DN （Distinguished Name）的属性（Attribute），DN是用来引用条目的，DN相当于关系数据库表中的关键字（Primary Key）。属性由类型（Type）和一个或多个值（Values）组成，相当于关系数据库中的字段（Field）由字段名和数据类型组成，只是为了方便检索的需要，LDAP中的Type可以有多个Value，而不是关系数据库中为降低数据的冗余性要求实现的各个域必须是不相关的。LDAP中条目的组织一般按照地理位置和组织关系进行组织，非常的直观。LDAP把数据存放在文件中，为提高效率可以使用基于索引的文件数据库，而不是关系数据库。类型的一个例子就是mail，其值将是一个电子邮件地址。

LDAP的信息是以树型结构存储的，在树根一般定义国家(c=CN)或域名(dc=com)，在其下则往往定义一个或多个组织 (organization)(o=Acme)或组织单元(organizational units) (ou=People)。一个组织单元可能包含诸如所有雇员、大楼内的所有打印机等信息。此外，LDAP支持对条目能够和必须支持哪些属性进行控制，这是有一个特殊的称为对象类别(objectClass)的属性来实现的。该属性的值决定了该条目必须遵循的一些规则，其规定了该条目能够及至少应该包含哪些属性。例如：inetorgPerson对象类需要支持sn(surname)和cn(common name)属性，但也可以包含可选的如邮件，电话号码等属性。

LDAP简称对应

o：organization（组织-公司）

ou：organization unit（组织单元-部门）

c：countryName（国家）

dc：domainComponent（域名）

sn：suer name（真实名称）

cn：common name（常用名称）

以上内容参考自：LDAP快速入门

其中， spring-boot-starter-data-ldap是Spring Boot封装的对LDAP自动化配置的实现，它是基于spring-data-ldap来对LDAP服务端进行具体操作的。

而 unboundid-ldapsdk主要是为了在这里使用嵌入式的LDAP服务端来进行测试操作，所以 scope设置为了test，实际应用中，我们通常会连接真实的、独立部署的LDAP服务器，所以不需要此项依赖。