package com.example.demo.jvm.loader;

import java.math.BigDecimal;

/**
 * Created by jiaozhiguang on 2017/9/18.
 *
 * 从上面的结果可以看出，并没有获取到ExtClassLoader的父Loader，
 * 原因是Bootstrap Loader（引导类加载器）是用C语言实现的，找不到一个确定的返回父Loader的方式，于是就返回null。
 *
 * 注意：这里父类加载器并不是通过继承关系来实现的，而是采用组合实现的。
 *
 * 启动类加载器：Bootstrap ClassLoader，负责加载存放在JDK\jre\lib(JDK代表JDK的安装目录，下同)下，
 * 或被-Xbootclasspath参数指定的路径中的，并且能被虚拟机识别的类库（如rt.jar，所有的java.开头的类均被Bootstrap ClassLoader加载）。
 * 启动类加载器是无法被Java程序直接引用的。
 *
 * 扩展类加载器：Extension ClassLoader，该加载器由sun.misc.Launcher$ExtClassLoader实现，它负责加载JDK\jre\lib\ext目录中，
 * 或者由java.ext.dirs系统变量指定的路径中的所有类库（如javax.开头的类），开发者可以直接使用扩展类加载器。
 *
 * 应用程序类加载器：Application ClassLoader，该类加载器由sun.misc.Launcher$AppClassLoader来实现，
 * 它负责加载用户类路径（ClassPath）所指定的类，
 * 开发者可以直接使用该类加载器，如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器。
 *
 *
 * 应用程序都是由这三种类加载器互相配合进行加载的，如果有必要，我们还可以加入自定义的类加载器。
 * 因为JVM自带的ClassLoader只是懂得从本地文件系统加载标准的java class文件，因此如果编写了自己的ClassLoader，便可以做到如下几点：

 1、在执行非置信代码之前，自动验证数字签名。
 2、动态地创建符合用户特定需要的定制化构建类。
 3、从特定的场所取得java class，例如数据库中和网络中。


 JVM类加载机制

 全盘负责，当一个类加载器负责加载某个Class时，该Class所依赖的和引用的其他Class也将由该类加载器负责载入，除非显示使用另外一个类加载器来载入
 父类委托，先让父类加载器试图加载该类，只有在父类加载器无法加载该类时才尝试从自己的类路径中加载该类
 缓存机制，缓存机制将会保证所有加载过的Class都会被缓存，当程序中需要使用某个Class时，类加载器先从缓存区寻找该Class，只有缓存区不存在，
 系统才会读取该类对应的二进制数据，并将其转换成Class对象，存入缓存区。这就是为什么修改了Class后，必须重启JVM，程序的修改才会生效

 类加载有三种方式：

 1、命令行启动应用时候由JVM初始化加载
 2、通过Class.forName()方法动态加载
 3、通过ClassLoader.loadClass()方法动态加载
 */

public class ClassLoaderTest {
    public static void main(String[] args) {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        long l = 9223372036854775807L * 2;
        System.out.println(l);

        BigDecimal bigDecimal = new BigDecimal(9223372036854775807L ).multiply(new BigDecimal(2.1123));
        System.out.println(bigDecimal + "client");


        ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
            Class<?> cls = cl.loadClass("java.util.ArrayList");
            System.out.println(cls);
            ClassLoader actualLoader = cls.getClassLoader();
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
