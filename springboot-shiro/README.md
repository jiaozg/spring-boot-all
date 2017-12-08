集成shiro步骤：

(a) pom.xml中添加Shiro依赖；

(b) 注入Shiro Factory和SecurityManager。

(c) 身份认证

(d) 权限控制


anon:所有url都都可以匿名访问;
authc: 需要认证才能进行访问;
user:配置记住我或认证通过可以访问；