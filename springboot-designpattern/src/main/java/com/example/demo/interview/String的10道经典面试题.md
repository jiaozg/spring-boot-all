1、String是基本数据类型吗？
2、String是可变的话？
3、怎么比较两个字符串的值一样，怎么比较两个字符串是否同一对象？
4、switch中可以使用String吗？

5、String str = new String("abc");创建了几个对象，为什么？

6、String、StringBuffer、StringBuilder有什么区别？
7、String.trim()方法去掉的是哪些字符？

8、String可以被子类继承吗？

9、可以自定义java.lang.String类并使用吗？

10、String与byte[]两者相互之间如何转换？












1、String不是基本数据类型。 

2、String是final类型的，不可变。 

3、比较字符串的值是否相同用equals,比较字符串对象是否同一个用==。 

4、jdk7+中的switch可以使用String类型。 

5、创建了两个，"abc"本身创建在常量池，通过new又创建在堆中。

6、String、StringBuffer、StringBuilder最大的不同是String不可变，后者可变。StringBuffer是线程安全的，StringBuilder线程不安全速度较快。

7、trim去掉字符串首尾的空白字符。 

8、既然String是final的，所以不能被继承。 

9、可以自定义java.lang.String类并编译成功，但不能被加载使用，具体请学习类加载机制。 

10、String > byte[] 通过String类的getBytes方法；byte[] > String通过new String(byte[])构造器。