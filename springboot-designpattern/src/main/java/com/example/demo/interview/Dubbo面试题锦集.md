1、默认使用的是什么通信框架，还有别的选择吗?

2、服务调用是阻塞的吗？

3、一般使用什么注册中心？还有别的选择吗？

4、默认使用什么序列化框架，你知道的还有哪些？

5、服务提供者能实现失效踢出是什么原理？

6、服务上线怎么不影响旧版本？

7、如何解决服务调用链过长的问题？

8、说说核心的配置有哪些？

9、dubbo推荐用什么协议？

10、同一个服务多个注册的情况下可以直连某一个服务吗？

11、画一画服务注册与发现的流程图

12、集群容错怎么做？

13、在使用过程中都遇到了些什么问题？

14、dubbo和dubbox之间的区别？

15、你还了解别的分布式框架吗？








1、默认也推荐使用netty框架，还有mina。 

2、默认是阻塞的，可以异步调用，没有返回值的可以这么做。 

3、推荐使用zookeeper注册中心，还有redis等不推荐。 

4、默认使用Hessian序列化，还有Duddo、FastJson、Java自带序列化。 

5、服务失效踢出基于zookeeper的临时节点原理。 

6、采用多版本开发，不影响旧版本。

7、可以结合zipkin实现分布式服务追踪。 

8、核心配置有 dubbo:service/ dubbo:reference/ dubbo:protocol/ dubbo:registry/ dubbo:application/ dubbo:provider/ dubbo:consumer/ dubbo:method/ 

9、默认使用dubbo协议。 

10、可以直连，修改配置即可，也可以通过telnet直接某个服务。 

11、流程图见dubbo.io。 

12、读操作建议使用Failover失败自动切换，默认重试两次其他服务器。写操作建议使用Failfast快速失败，发一次调用失败就立即报错。 

13、使用过程中的问题可以百度 

14、dubbox是当当网基于dubbo上做了一些扩展，如加了服务可restful调用，更新了开源组件等。 

15、别的还有spring的spring cloud，facebook的thrift，twitter的finagle等。










