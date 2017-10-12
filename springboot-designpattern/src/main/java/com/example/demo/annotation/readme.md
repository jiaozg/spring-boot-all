神奇的注解
通过以上的例子，我们可以看出，注解似乎有某种神奇的力量，通过简单的声明，就可以达到某种效果。
在某些方面，它类似序列化机制中通过简单的Serializable接口，
Java就能自动处理很多复杂的事情。它也类似于我们在并发部分中介绍的synchronized关键字，
通过它可以自动实现同步访问。

这些都是声明式编程风格，在这种风格中，程序都由三个组件组成：
声明的关键字和语法本身
系统/框架/库，它们负责解释、执行声明式的语句
应用程序，使用声明式风格写程序

在编程的世界里，访问数据库的SQL语言，编写网页样式的CSS，以及后续章节将要介绍的正则表达式、
函数式编程都是这种风格，这种风格降低了编程的难度，为应用程序员提供了更为高级的语言，
使得程序员可以在更高的抽象层次上思考和解决问题，而不是陷于底层的细节实现。

@Override的定义
我们通过一些例子来说明，先看@Override的定义：
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}

定义注解与定义接口有点类似，都用了interface，不过注解的interface前多了@，另外，它还有两个元注解@Target和@Retention，这两个注解专门用于定义注解本身。

@Target
@Target表示注解的目标，@Override的目标是方法(ElementType.METHOD)，ElementType是一个枚举，其他可选值有：
TYPE：表示类、接口（包括注解），或者枚举声明
FIELD：字段，包括枚举常量
METHOD：方法
PARAMETER：方法中的参数
CONSTRUCTOR：构造方法
LOCAL_VARIABLE：本地变量
ANNOTATION_TYPE：注解类型
PACKAGE：包

目标可以有多个，用{}表示，比如@SuppressWarnings的@Target就有多个，定义为：
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value();
}

如果没有声明@Target，默认为适用于所有类型。

@Retention
@Retention表示注解信息保留到什么时候，取值只能有一个，类型为RetentionPolicy，它是一个枚举，有三个取值：
SOURCE：只在源代码中保留，编译器将代码编译为字节码文件后就会丢掉
CLASS：保留到字节码文件中，但Java虚拟机将class文件加载到内存时不一定会在内存中保留
RUNTIME：一直保留到运行时

如果没有声明@Retention，默认为CLASS。

@Override和@SuppressWarnings都是给编译器用的，所以@Retention都是RetentionPolicy.SOURCE。


注解提升了Java语言的表达能力，有效地实现了应用功能和底层功能的分离，
框架/库的程序员可以专注于底层实现，借助反射实现通用功能，提供注解给应用程序员使用，
应用程序员可以专注于应用功能，通过简单的声明式注解与框架/库进行协作。

