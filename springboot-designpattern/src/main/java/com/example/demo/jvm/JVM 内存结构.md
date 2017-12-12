堆内存、方法区和栈

堆内存是JVM中最大的一块由年轻代和老年代组成，而年轻代内存又被分成三部分，
Eden空间、From Survivor空间、To Survivor空间,默认情况下年轻代按照8:1:1的比例来分配

控制参数

-Xms设置堆的最小空间大小。
-Xmx设置堆的最大空间大小。
-XX:NewSize设置新生代最小空间大小。
-XX:MaxNewSize设置新生代最大空间大小。
-XX:PermSize设置永久代最小空间大小。
-XX:MaxPermSize设置永久代最大空间大小。
-Xss设置每个线程的堆栈大小。