jps jstat jmap jhat jstack jinfo

jps

JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。
option参数

-l : 输出主类全名或jar路径
-q : 只输出LVMID
-m : 输出JVM启动时传递给main()的参数
-v : 输出JVM启动时显示指定的JVM参数

示例
jps -l -m

jstat

jstat(JVM statistics Monitoring)是用于监视虚拟机运行时状态信息的命令，
它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。

命令格式

jstat [option] LVMID [interval] [count]
参数

[option] : 操作参数
LVMID : 本地虚拟机进程ID
[interval] : 连续输出的时间间隔
[count] : 连续输出的次数


option 参数总览

Option	Displays…
class	class loader的行为统计。Statistics on the behavior of the class loader.
compiler	HotSpt JIT编译器行为统计。Statistics of the behavior of the HotSpot Just-in-Time compiler.
gc	垃圾回收堆的行为统计。Statistics of the behavior of the garbage collected heap.
gccapacity	各个垃圾回收代容量(young,old,perm)和他们相应的空间统计。Statistics of the capacities of the generations and their corresponding spaces.
gcutil	垃圾回收统计概述。Summary of garbage collection statistics.
gccause	垃圾收集统计概述（同-gcutil），附加最近两次垃圾回收事件的原因。Summary of garbage collection statistics (same as -gcutil), with the cause of the last and
gcnew	新生代行为统计。Statistics of the behavior of the new generation.
gcnewcapacity	新生代与其相应的内存空间的统计。Statistics of the sizes of the new generations and its corresponding spaces.
gcold	年老代和永生代行为统计。Statistics of the behavior of the old and permanent generations.
gcoldcapacity	年老代行为统计。Statistics of the sizes of the old generation.
gcpermcapacity	永生代行为统计。Statistics of the sizes of the permanent generation.
printcompilation	HotSpot编译方法统计。HotSpot compilation method statistics.


option 参数详解

-class

监视类装载、卸载数量、总空间以及耗费的时间

$ jstat -class 11589

Loaded : 加载class的数量
Bytes : class字节大小
Unloaded : 未加载class的数量
Bytes : 未加载class的字节大小
Time : 加载时间

-compiler

输出JIT编译过的方法数量耗时等

$ jstat -compiler 1262

Compiled : 编译数量
Failed : 编译失败数量
Invalid : 无效数量
Time : 编译耗时
FailedType : 失败类型
FailedMethod : 失败方法的全限定名

-gc

垃圾回收堆的行为统计，常用命令

jstat -gc 1262

jstat -gc 1262
 S0C    S1C     S0U     S1U   EC       EU        OC         OU        PC       PU         YGC    YGCT    FGC    FGCT     GCT   
26112.0 24064.0 6562.5  0.0   564224.0 76274.5   434176.0   388518.3  524288.0 42724.7    320    6.417   1      0.398    6.815

C即Capacity 总容量，U即Used 已使用的容量

S0C : survivor0区的总容量
S1C : survivor1区的总容量
S0U : survivor0区已使用的容量
S1U : survivor1区已使用的容量
EC : Eden区的总容量
EU : Eden区已使用的容量
OC : Old区的总容量
OU : Old区已使用的容量
PC	当前perm的容量 (KB)
PU	perm的使用 (KB)
YGC : 新生代垃圾回收次数
YGCT : 新生代垃圾回收时间
FGC : 老年代垃圾回收次数
FGCT : 老年代垃圾回收时间
GCT : 垃圾回收总消耗时间


jstat -gc 1262 2000 20
这个命令意思就是每隔2000ms输出1262的gc情况，一共输出20次

-gccapacity

同-gc，不过还会输出Java堆各区域使用到的最大、最小空间

NGCMN : 新生代占用的最小空间
NGCMX : 新生代占用的最大空间
OGCMN : 老年代占用的最小空间
OGCMX : 老年代占用的最大空间
OGC：当前年老代的容量 (KB)
OC：当前年老代的空间 (KB)
PGCMN : perm占用的最小空间
PGCMX : perm占用的最大空间

-gcutil

同-gc，不过输出的是已使用空间占总空间的百分比

-gccause

垃圾收集统计概述（同-gcutil），附加最近两次垃圾回收事件的原因

LGCC：最近垃圾回收的原因
GCC：当前垃圾回收的原因

-gcnew

统计新生代的行为

$ jstat -gcnew 28920

TT：Tenuring threshold(提升阈值)
MTT：最大的tenuring threshold
DSS：survivor区域大小 (KB)


-gcnewcapacity

新生代与其相应的内存空间的统计

NGC:当前年轻代的容量 (KB)
S0CMX:最大的S0空间 (KB)
S0C:当前S0空间 (KB)
ECMX:最大eden空间 (KB)
EC:当前eden空间 (KB)


-gcold

统计旧生代的行为

-gcoldcapacity

统计旧生代的大小和空间

-gcpermcapacity

永生代行为统计

-printcompilation

hotspot编译方法统计

Compiled：被执行的编译任务的数量
Size：方法字节码的字节数
Type：编译类型
Method：编译方法的类名和方法名。类名使用”/” 代替 “.” 作为空间分隔符. 方法名是给出类的方法名. 
格式是一致于HotSpot - XX:+PrintComplation 选项

jmap

jmap(JVM Memory Map)命令用于生成heap dump文件，如果不使用这个命令，还阔以使用-XX:+HeapDumpOnOutOfMemoryError参数来让虚拟机出现OOM的时候·自动生成dump文件。 jmap不仅能生成dump文件，还阔以查询finalize执行队列、Java堆和永久代的详细信息，如当前使用率、当前使用的是哪种收集器等。

命令格式

jmap [option] LVMID
option参数

dump : 生成堆转储快照
finalizerinfo : 显示在F-Queue队列等待Finalizer线程执行finalizer方法的对象
heap : 显示Java堆详细信息
histo : 显示堆中对象的统计信息
permstat : to print permanent generation statistics
F : 当-dump没有响应时，强制生成dump快照


示例

-dump

常用格式

-dump::live,format=b,file=<filename> pid 

-heap

打印heap的概要信息，GC使用的算法，heap的配置及wise heap的使用情况,可以用此来判断内存目前的使用情况以及垃圾回收情况

$ jmap -heap 28920

jhat

jhat(JVM Heap Analysis Tool)命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，
生成dump的分析结果后，可以在浏览器中查看。在此要注意，一般不会直接在服务器上进行分析，
因为jhat是一个耗时并且耗费硬件资源的过程，一般把服务器生成的dump文件复制到本地或其他机器上进行分析。

Http://localhost:7000

jstack

jstack用于生成java虚拟机当前时刻的线程快照。线程快照是当前java虚拟机内每一条线程正在执行的方法堆栈的集合，
生成线程快照的主要目的是定位线程出现长时间停顿的原因，如线程间死锁、死循环、请求外部资源导致的长时间等待等。 
线程出现停顿的时候通过jstack来查看各个线程的调用堆栈，就可以知道没有响应的线程到底在后台做什么事情，或者等待什么资源。
 如果java程序崩溃生成core文件，jstack工具可以用来获得core文件的java stack和native stack的信息，
 从而可以轻松地知道java程序是如何崩溃和在程序何处发生问题。另外，jstack工具还可以附属到正在运行的java程序中，
 看到当时运行的java程序的java stack和native stack的信息, 如果现在运行的java程序呈现hung的状态，jstack是非常有用的。
 
 