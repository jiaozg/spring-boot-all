https://zhuanlan.zhihu.com/p/34289466?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io

https://docs-apis.apigee.io/files/Web-design-the-missing-link-ebook-2016-11.pdf

http://link.zhihu.com/?target=http%3A//zalando.github.io/restful-api-guidelines/

写文章登录
设计一套良好 REST API
Yi Wang
Yi Wang
9 天前
硅谷的apigee公司给出一份对REST API的设计指导原则，可以说这家公司在api开发，管理的成绩有目共睹。其提供的指导原则，可以说结合了其自身实际开发经验，诸多大型平台的实际运营经验和标准http规范。非常值得一读。

首先，你需要对REST API有一个基本的概念认知，然后再深入阅读：

1. 基于业务领域的数据建模，而非基于功能建模。
例如，取得所有的dog

GET /api/dogs 
取得一个特定的dog

GET /api/dogs/{id}
取得特定名字的dogs

GET /api/dogs/?name=xxx
创建一个dog

POST /api/dogs
更改一个dog

PUT /api/dogs/{id}
删除一个dog

DELETE /api/dogs/{id}
标准的HTTP的方法已经提供了一套约定俗成的操作语义。

而一个基于功能建模的api，通常会是下面的样子：

/getAllDogs
/getDogsByNames
/getAllBabyDogs
/createDogs
/createThreeDogs
/saveDogs
以上这些我经常在新手的代码里看到。这样做的代码，没错，可以运行，但是不‘标准’ why？基于功能建模的api，首先会造成学习曲线的增长，不容易上手，也往往意味着需要记忆大量的url（swagger会解决一部分这个问题，但不是全部）。

使用HTTP的标准方法作为操作数据的基本语义，胜在其标准的普适性。这一点上，大的平台Github，Heroku等，做的是最好的。

2. 设计数据的表现形式
毫无疑问，使用JSON，今天JSON已经是事实上的web数据标准，简单易懂。但是JSON也有其缺点，比如如何表达Date和Timestamp，一个简单的做法是用string来表达，根据上下文来判断如何解释。尽量保持JSON数据的简洁性。

并且使用link去表达资源之间的联系：

例如：

{ 
 "id": "12345678",
 "kind": "Dog"
 "name": "Lassie",
 "furColor": "brown",
 "ownerID": "98765432"
}
更好的方法：

{
 "id": "12345678",
 "kind": "Dog"
 "name": "Lassie",
 "furColor": "brown",
 "ownerID": "98765432",
 "ownerLink": "https://dogtracker.com/persons/98765432"
}
更简洁的表示：

{
 "id": "12345678",
 "kind": "Dog"
 "name": "Lassie",
 "furColor": "brown",
 "owner": "https://dogtracker.com/persons/98765432"
}
这样做的好处是客户端不需要自己重新构建URL去获取owner，更方便使用。Google Drive API 和 Github 均使用这种方式。但这样做也不是没有坏处，最容易想到的是，如果url改变了怎么办？production，staging，testing用的是不一样的domain哟。一个方法是：使用相对路径，而不是绝对路径。但这也不能解决全部问题。



3. 设计URL的表现形式
两大原则：规范的（regular），可预测的（predictable）。

只使用名词
要有切入点
要合适的选择id形式
要表达资源间的联系
要支持查询
要支持返回部分资源
处理更复杂的计算逻辑
只使用名词：在URL中使用名词，避免动词，一旦使用动词，意味着你是在对功能建模，而非数据。



要有切入点：原则上来讲，一个api应该有一个root path '/', 其返回一个url map，包括了所有的resouces所对应的url。这样客户端更容易去发现和使用api。



要合适的选择id形式：例如api/dogs/{id} 中的{id}如何表达，是类似于‘/dogs/1’，还是‘/dogs/haha’? 一般来说取决于后端的数据库，大多数情况下，使用RDBMS，像mysql之类的主键自增功能，我比较倾向于使用自增主键的整数直接作为entity的id，避免很多问题，如果使用MongoDB的话，不妨试一试用字符串作为entity的id，可读性会提高，但是如何维护一个全局唯一的字符主键，你得三思。



要表达资源间的联系：比如 GET /persons/1/dogs 返回所有属于person 1的狗。
这种模式可以表述为：

/{relationship-name}[/{resource-id}]/…/{relationship-name}[/{resource-id}]


要支持查询：

GET /persons;1/dogs GET /persons;name=blabla/dogs 
这种模式可以表述为：

/{relationship-name}[;{selector}]/…/{relationship-name}[;{selector}]
更复杂的查询条件：

GET /dogs?color=red&state=running&location=park 
注意这里的三个查询子条件之间的关系是‘与（and）’,如果要表达是‘或（or）’的逻辑，那就得设计更复杂的query解释机制。但其实实际使用中，表达‘或’的查询条件很少使用。



要支持返回部分资源:

/dogs?fields=name,color,location 
返回的resource中，只包含name,color,location三种信息。



处理更复杂的计算逻辑: 有很多例子，比如货币转换，大多数开发人员给出的方案是：

/convert/100/EUR/CNY 或者 /convert?quantity=100&unit=EUR&in=CNY

切记：URL是用来表述资源resource，而不是表述计算的过程。在URL中使用名词，避免动词。

改进的方案1：

GET /monetary-amount/100/EUR HTTP/1.1
Host: Currency-Converter.com
Accept-Currency:CNY //在http的header中添加Accept-Currency来指明货币的种类。
改进的方案2：

POST /currency-converter HTTP/1.1
Host: Currency-Converter.com 
Content-Length: 69
{
"amount": 100,
"inputCurrency": "EUR",
"outputCurrency": "CNY"
}
两个方案都可行，但是方案2有两个注意的地方：POST返回的结果可能无法再server端缓存;你是在构建一个计算的过程，而非资源的表述，如何理解？就像数据库操作中的‘store procedure’，你可以使用，并且功能强大，但是接口变得复杂，逻辑变得耦合。



4. 反思-设计数据的表现形式。
添加self link
集合数据
数据分页
数据格式
添加self link：self link提供了一个上下文环境，客户端可以更容易理解当前的resource的位置

{
 "user": {
   "html_url": "octocat (The Octocat)",
   "type": "User",
   "url": "https://api.github.com/users/octocat"
 }
}


集合数据：

方案1：集合collection也是一种resource，也具有self和kind属性，这样所有的单独entity和collection都具有更加统一的规范

{
	"self": "https://dogtracker.com/dogs",
	"kind": "Collection",
	"contents": [
	 	{
	 		"self": "https://dogtracker.com/dogs/12344",
	 		"kind": "Dog",
		 	"name": "Fido",
		 	"furColor": "white"
		 },
		 {
			 "self": "https://dogtracker.com/dogs/12345",
			 "kind": "Dog",
			 "name": "Rover",
			 "furColor": "brown"
		 }
	 ]
}
方案2：看起来更加简洁，但是客户端可能需要去添加额外的逻辑去处理collection

[
	{
		"self": "https://dogtracker.com/dogs/12344",
		"kind": "Dog",
	 	"name": "Fido",
	 	"furColor": "white"
	 },
	 {
		 "self": "https://dogtracker.com/dogs/12345",
		 "kind": "Dog",
		 "name": "Rover",
		 "furColor": "brown"
	 }
]
还有一种做法是，针对一个collection，使用自定义的media type header（比如‘Collection+JSON’）这个方法可行，但是会让客户端的处理逻辑复杂。



数据分页：当数据返回的集合变大时，显然不可能一次性把所有数据都返回给客户端，最好能分批的返回，比如：

GET https://dogtracker.com/dogs?limit=25,offset=0 
返回
{
"self": "https://dogtracker.com/dogs?limit=25,offset=0",
"kind": "Page",
"pageOf": "https://dogtracker.com/dogs",
"next": "https://dogtracker.com/dogs?limit=25,offset=25",
"contents": [...】
}
在返回的数据中，加入‘pageOf’来指明查询的起点，‘next’指明下一页的url，当返回第二页的时候，还需加入‘previous’来指明上一页。



数据格式：现在大多数的api几乎只支持JOSN格式的数据来作为input和output，如果要支持更多的数据格式，那么应该要支持Http Accept Header。

能否用HTML作为输出的格式？可以，但是这样就丧失的rest API的灵活性。现代的web应用，大多使用REST API + SPA的设计，SPA端使用Angular等框架，自己渲染HTML，REST API只提供数据服务，前端后端通过JSON数据来交流，从而实现了前后端的彻底解耦。

如果选择JSON作为唯一的数据格式，那么最好支持Http的patch方法，现在有两种patch的模式：JSON Patch和JSON Merge Patch，选择一个来用于资源的更新操作。现在也有很多API只提供PUT来更新资源，这意味着每次请求都必须发送整个resource enrity，势必会消耗更多的payload，但是实现起来更容易。



5. 错误处理
总的原则：使用标准http的status code来表示错误的类型。具体的错误内容，也要被返回。



6. 认证和授权
人生苦短，使用OAuth2。最起码也要使用基于token的鉴权模式。



7. SDK
可以推出SDK来作为你的REST API的一个补充，就像AWS那样，针对每一个服务，都有相应的编程语言的SDK。这样更方便第三方的开发人员使用你的api。多见于SaaS平台。但是小型的平台，得考虑维护的成本。



8. Versioning 多版本
REST API的版本控制问题是一个非常有争议的话题，网上的提议有很多，在这里我们不是简单的给定具体的方法，而是提供几种可行的想法，具体的实施还需自己拿捏：

不（显式）支持多版本
使用Http Accept Header
第一种，什么都不做，不支持多版本的api。这个想法的背后依据是，根据调研发现，大多数的中小型规模的平台服务，客户规模都在一个可控的范围，api的升级不会很频繁，你只需通知你的客户，在某个时间点api会更新，然后再server端做一些兼容性的数据迁移，比如增加或删除某个数据库中的表的某个列的名字。大多数情况下，支持多版本api费力不讨好，测试和部署的成本很大，收益却很小。你要做就是保持唯一个可用api服务的兼容性，而不是提供多个版本的api让用户使用。

第二种，如果你一定要支持versioning，那么就在http的accept header中添加version信息，不要在url中使用version信息，千万不要用/api/v1/xxx。



总结
https://docs-apis.apigee.io/files/Web-design-the-missing-link-ebook-2016-11.pdf
​docs-apis.apigee.io
在实际的工作中，对于刚入职的小盆友，在介绍REST API的时候，我会推荐他们读这个。

这篇文章给出的是原则上的指导，对于开发团队，我建议在团队内部要制定一个更具体详细的规范specification，具体的可以参考：Zalando RESTful API and Event Scheme Guidelines 其中的规范涵盖了很多细节内容，细节的规范越多，代码风格才越统一，团队沟通效率才越高。

REST
API
开放 API
软件设计
46
Fndroid
BUPTGuo
丛裕
呆呆笨笨
果洛
收藏
分享
举报
5 条评论
写下你的评论...

江湖人称某二代
江湖人称某二代
你好，感谢你的分享。请问为什么“千万不要用/api/v1/xxx”？有什么不妥吗？

2 赞
4 天前
平叶
平叶
为什么不要用"api/v1"?

1 赞
4 天前
王旭
 查看对话
王旭回复平叶
建议版本信息放http头
4 天前
头条君
头条君
感谢分享！已推荐到《开发者头条》：设计一套良好 REST API - 1码平川的独家号 - 开发者头条 欢迎点赞支持！

欢迎订阅《1码平川的独家号》热门分享 - 1码平川的独家号

3 天前

选择语言
