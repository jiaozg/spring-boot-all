package com.example.demo.jvm.loader;

import sun.jvm.hotspot.HelloWorld;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/9/18.
 *
 双亲委派模型

 双亲委派模型的工作流程是：如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把请求委托给父加载器去完成，
 依次向上，因此，所有的类加载请求最终都应该被传递到顶层的启动类加载器中，只有当父加载器在它的搜索范围中没有找到所需的类时，
 即无法完成该加载，子加载器才会尝试自己去加载该类。

 双亲委派机制:

 1、当AppClassLoader加载一个class时，它首先不会自己去尝试加载这个类，而是把类加载请求委派给父类加载器ExtClassLoader去完成。
 2、当ExtClassLoader加载一个class时，它首先也不会自己去尝试加载这个类，而是把类加载请求委派给BootStrapClassLoader```去完成。
 3、如果BootStrapClassLoader加载失败（例如在$JAVA_HOME/jre/lib里未查找到该class），会使用ExtClassLoader来尝试加载；
 4、若ExtClassLoader也加载失败，则会使用AppClassLoader来加载，如果AppClassLoader也加载失败，则会报出异常ClassNotFoundException。

 双亲委派模型意义：

 系统类防止内存中出现多份同样的字节码
 保证Java程序安全稳定运行


 Class.forName()和ClassLoader.loadClass()区别

 Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
 ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
 Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象 。



 */
public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
//        loader.loadClass("com.example.demo.Test2");
        //使用Class.forName()来加载类，默认会执行初始化块
//        Class.forName("com.example.demo.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
//        Class.forName("com.example.demo.Test2", false, loader);
        Class.forName("com.example.demo.Test2", true, loader);

        System.out.println(HelloWorld.fib(10));

        List<Test2> list = new ArrayList<>();
        for(long i=0; i< Long.MAX_VALUE; i++) {
//            System.out.println("111");
            list.add(new Test2());
        }


    }

}
