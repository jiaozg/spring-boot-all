5 亿整数的大文件，怎么排
    内存极少的情况下，利用分治策略，利用外存保存中间结果，再用多路归并来排序;
    map-reduce的嫡系.
    1.分
    内存中维护一个极小的核心缓冲区memBuffer，将大文件bigdata按行读入，搜集到memBuffer满或者大文件读完时，对memBuffer中的数据调用内排进行排序，排序后将有序结果写入磁盘文件bigdata.xxx.part.sorted.
    循环利用memBuffer直到大文件处理完毕，得到n个有序的磁盘文件：
    2.合
    现在有了n个有序的小文件，怎么合并成1个有序的大文件？
    把所有小文件读入内存，然后内排？
    no!
    利用如下原理进行归并排序：
    我们举个简单的例子：
    文件1：3,6,9
    文件2：2,4,8
    文件3：1,5,7
    第一回合：
    文件1的最小值：3 , 排在文件1的第1行
    文件2的最小值：2，排在文件2的第1行
    文件3的最小值：1，排在文件3的第1行
    那么，这3个文件中的最小值是：min(1,2,3) = 1
    也就是说，最终大文件的当前最小值，是文件1、2、3的当前最小值的最小值，绕么？
    上面拿出了最小值1，写入大文件.
    第二回合：
    文件1的最小值：3 , 排在文件1的第1行
    文件2的最小值：2，排在文件2的第1行
    文件3的最小值：5，排在文件3的第2行
    那么，这3个文件中的最小值是：min(5,2,3) = 2
    将2写入大文件.


一、阿里巴巴面试

第一个：阿里面试都问什么？ ：（55分钟）

1、开发中Java用了比较多的数据结构有哪些？

2、谈谈你对HashMap的理解，底层原理的基本实现，HashMap怎么解决碰撞问题的？

这些数据结构中是线程安全的吗？假如你回答HashMap是线程安全的，接着问你有没有线程安全的map，接下来问了conurren包。

3、对JVM熟不熟悉？简单说说类加载过程，里面执行的哪些操作?问了GC和内存管理，平时在tomect里面有没有进行过相关的配置

4、然后问了http协议，get和post的基本区别，接着tcp/ip协议，三次握手，窗口滑动机制。

5、开发中用了那些数据库？回答mysql，储存引擎有哪些？然后问了我悲观锁和乐观锁问题使用场景、分布式集群实现的原理。

6、然后问了我springmvc和mybatis的工作原理，有没有看过底层源码？

二、京东金融面试

1、Dubbo超时重试；Dubbo超时时间设置

2、如何保障请求执行顺序
    mq

3、分布式事物与分布式锁（扣款不要出现负数）

4、分布式session设置

5、执行某操作，前50次成功，第51次失败a全部回滚b前50次提交第51次抛异常，ab场景分别如何设置Spring（传播性）

6、Zookeeper有哪些用
    注册中心，分布式锁，Master选举，服务器监控
    https://mp.weixin.qq.com/s?__biz=MzAxOTc0NzExNg==&mid=2665514106&idx=1&sn=e54aae8cf68f5afcc2978585170df0b8&chksm=80d67c39b7a1f52fe0d51d81464a979d50778ebbcd81159345599f21f8789f2cbf8d7044a174&mpshare=1&scene=23&srcid=1205k0QbtwxqdRCAtmpQTaJ7#rd

7、JVM内存模型

8、数据库垂直和水平拆分

9、MyBatis如何分页；如何设置缓存；MySQL分页

10、熟悉IO么？与NIO的区别，阻塞与非阻塞的区别

11、分布式session一致性

12、分布式接口的幂等性设计「不能重复扣款」
http://blog.csdn.net/rickiyeat/article/details/71087747
    怎么完善 buy_commodity() 接口的幂等性呢？借鉴银行等金融系统的做法, 引入 票据 (token) 是个不错的主意:
    Jack 花费点券购买道具, 先到 shop_svr 中去申请交易票据 token. 
    shop_svr 生成唯一 token, 并记录到 DB. 
    Jack 拿到 token, 调用接口 buy_commodity(token, commodity_id) 购买. 
    由于网络延迟, 或者系统负载比较高, shop_svr 没来得及返回, 总之, 第一次调用超时了没返回. 
    Jack 重试购买, 仍然调用接口 buy_commodity(token, commodity_id) . 
    shop_svr 收到第一次 buy_commodity() 请求, 验证 token 之后完成购买行为, 再将 token 标记为已执行, 这是个 原子行为 . 
    shop_svr 收到第二次 buy_commodity() 请求, 验证 token 失败, 丢弃消息. 
    票据 (token) 机制, 保证了 buy_commodity() 接口的幂等性 , 同样的请求, 并不会对系统造成额外的 side-effects, 即多次调用预期保持一致, 问题解决!

三、美团面试

1、最近做的比较熟悉的项目是哪个？画一下项目技术架构图

2、JVM老年代和新生代的比例？
    默认的，新生代 ( Young ) 与老年代 ( Old ) 的比例的值为 1:2 ( 该值可以通过参数 –XX:NewRatio 来指定 )，即：新生代 ( Young ) = 1/3 的堆空间大小。老年代 ( Old ) = 2/3 的堆空间大小。其中，新生代 ( Young ) 被细分为 Eden 和 两个 Survivor 区域，这两个 Survivor 区域分别被命名为 from 和 to，以示区分。
    默认的，Edem : from : to = 8 : 1 : 1 ( 可以通过参数 –XX:SurvivorRatio 来设定 )，即： Eden = 8/10 的新生代空间大小，from = to = 1/10 的新生代空间大小。
    JVM 每次只会使用 Eden 和其中的一块 Survivor 区域来为对象服务，所以无论什么时候，总是有一块 Survivor 区域是空闲着的。
    因此，新生代实际可用的内存空间为 9/10 ( 即90% )的新生代空间。

3、YGC和FGC发生的具体场景
    YGC的时机:
        edn空间不足
    FGC的时机：
        1.old空间不足；
        2.perm空间不足；
        3.显示调用System.gc() ，包括RMI等的定时触发;
        4.YGC时的悲观策略；
        5.dump live的内存信息时(jmap –dump:live)。

4、jstack，jmap 分别的意义？如何线上排查JVM的相关问题？
    jstack用于生成java虚拟机当前时刻的线程快照。线程快照是当前java虚拟机内每一条线程正在执行的方法堆栈的集合，生成线程快照的主要目的是定位线程出现长时间停顿的原因，如线程间死锁、死循环、请求外部资源导致的长时间等待等。 线程出现停顿的时候通过jstack来查看各个线程的调用堆栈，就可以知道没有响应的线程到底在后台做什么事情，或者等待什么资源。 如果java程序崩溃生成core文件，jstack工具可以用来获得core文件的java stack和native stack的信息，从而可以轻松地知道java程序是如何崩溃和在程序何处发生问题。另外，jstack工具还可以附属到正在运行的java程序中，看到当时运行的java程序的java stack和native stack的信息, 如果现在运行的java程序呈现hung的状态，jstack是非常有用的。
    jmap(JVM Memory Map)命令用于生成heap dump文件，如果不使用这个命令，还阔以使用-XX:+HeapDumpOnOutOfMemoryError参数来让虚拟机出现OOM的时候·自动生成dump文件。 jmap不仅能生成dump文件，还阔以查询finalize执行队列、Java堆和永久代的详细信息，如当前使用率、当前使用的是哪种收集器等。
    jps JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。
    jstat(JVM statistics Monitoring)是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。
    

5、线程池的构造类的方法的5个参数的具体意义？
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue)

6、单机上一个线程池正在处理服务如果忽然断电该怎么办？（正在处理和阻塞队列里的请求怎么处理）？

7、使用无界阻塞队列会出现什么问题？
    内存溢出

8、接口如何处理重复请求？
    幂等性 token

9、具体处理方案是什么？

10、如何保证共享变量修改时的原子性？
    使用synchronized关键字
    使用显式锁
    使用原子变量

11、设计一个对外服务的接口实现类，在1,2,3这三个主机（对应不同IP）上实现负载均衡和顺序轮询机制（考虑并发）
    nginx 

四、滴滴面试

1、自我介绍，技术特点

2、兴趣是什么，优势是什么

3、jvm，jre以及jdk三者之间的关系？

4、Dubbo的底层原理，Zookeeper是什么
   netty ,注册中心
 
5、cincurrentMap的机制；TreeMap；Volatil关键字

6、快速排序；广度优先搜索（队列实现）

7、缓存的雪崩以及穿透的理解？
    雪崩：大量缓存同时失效
    穿透：大量请求没走缓存，直接到数据库

8、HashMap的key可以重复吗？
    判断key是否存在的时候是先比较key的hashCode，再比较相等或equals的，所以重写hashCode()和equals()方法即可实现添加重复元素

9、synchronized和lock的区别？
    synchronized一个是关键字，悲观锁，
    Lock是接口，相当于乐观锁，粒度更细，性能更好，开发复杂

10.开发一个大型网站你会考虑哪些问题?
    高可用(服务的无状态化, 服务发现与注册, 心跳的检测, 幂等性的设计, 重试机制， 服务集群，服务超时的问题，限流、服务降级 1，拒绝部分请求，2，关闭部分服务 不能强一致性，但是我们可以做到最终一致性，调用链监控预警，分布式日志)，
    高性能()，
    高扩展()

微服务这块给大家分享一个学习图谱


服务器io模型
    服务端编程，首要问题是选取IO模型。即如何处理大量连接，服务更多的客户端？
    我们最早有2种解法，各有不足：
    1、阻塞IO，每个连接都需要一个线程。
        随着连接数增多，线程数剧增，系统开销太大。
    2、非阻塞IO，采用“忙轮询”的方式处理多个连接。
         空闲连接很多时，太浪费CPU。
    现在，业内常用方案是IO复用。
    单线程处理大量连接，应用不需要“忙轮询”，内核发现“活跃连接”通知应用。所有连接都空闲时，阻塞应用线程，释放CPU。
  从IO的访问方式来看，可以分为阻塞／非阻塞，同步／异步。在Linux，提供了5种IO模型：
    阻塞I/O：blocking I/O
    非阻塞I/O ：nonblocking I/O
    I/O复用：I/O multiplexing (select 和poll) 
    信号驱动I/O ：signal driven I/O (SIGIO)
    异步I/O ：asynchronous I/O (the POSIX aio_functions)

代码如何优化
    http://www.cnblogs.com/xrq730/p/4865416.html
    
动态代理是实现面向切面的编程(AOP - Aspect Oriented Programming)的基础，切面的例子有日志、性能监控、权限检查、数据库事务

String replace、replaceAll、replaceFirst的区别详解
    原来String的replaceAll跟replaceFirst用到了正则表达式
    
Comparable和Comparator区别比较
　　Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

　　Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。

　　两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候，把比较器和对象一起传递过去就可以比大小了， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。

mysql建索引的几大原则
    2．为经常需要排序、分组和联合操作的字段建立索引
    3．为常作为查询条件的字段建立索引
    4．限制索引的数目
    5．尽量使用数据量少的索引
    6．尽量使用前缀来索引
    8 . 最左前缀匹配原则，非常重要的原则。
    11 .索引列不能参与计算，保持列“干净”。
    
https://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247485111&idx=1&sn=8b0ef997304db302b66f434cf5c029bc&chksm=eb538381dc240a970f318eca90e476a30c1d76fcf0b7392fb2e26f94180bbfa275874cdfaa16&scene=21#wechat_redirect

