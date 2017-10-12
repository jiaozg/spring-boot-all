Lambda表达式

Lambda表达式是Java 8新引入的一种语法，是一种紧凑的传递代码的方式

通过接口传递代码

Collections的一些算法，很多方法都接受一个参数Comparator，比如：
public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) 
public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
public static <T> void sort(List<T> list, Comparator<? super T> c)

它们需要的也不是Comparator对象，而是它包含的如下方法：
int compare(T o1, T o2);

异步任务执行服务ExecutorService，提交任务的方法有：
<T> Future<T> submit(Callable<T> task);
<T> Future<T> submit(Runnable task, T result);
Future<?> submit(Runnable task);

Callable和Runnable接口也用于传递任务代码。

通过接口传递行为代码，就要传递一个实现了该接口的实例对象，在之前的章节中，最简洁的方式是使用匿名内部类，比如：
//列出当前目录下的所有后缀为.txt的文件
File f = new File(".");
File[] files = f.listFiles(new FilenameFilter(){
    @Override
    public boolean accept(File dir, String name) {
        if(name.endsWith(".txt")){
            return true;
        }
        return false;
    }
});

将files按照文件名排序，代码为：
Arrays.sort(files, new Comparator<File>() {

    @Override
    public int compare(File f1, File f2) {
        return f1.getName().compareTo(f2.getName());
    }
});

提交一个最简单的任务，代码为：
ExecutorService executor = Executors.newFixedThreadPool(100);
executor.submit(new Runnable() {
    @Override
    public void run() {
        System.out.println("hello world");
    }
});

Lambda表达式
语法
Java 8提供了一种新的紧凑的传递代码的语法 - Lambda表达式。对于前面列出文件的例子，代码可以改为：
File f = new File(".");
File[] files = f.listFiles((File dir, String name) -> {
    if (name.endsWith(".txt")) {
        return true;
    }
    return false;
});

可以看出，相比匿名内部类，传递代码变得更为直观，不再有实现接口的模板代码，不再声明方法，也名字也没有，而是直接给出了方法的实现代码。Lambda表达式由->分隔为两部分，前面是方法的参数，后面{}内是方法的代码。

上面代码可以简化为：
File[] files = f.listFiles((File dir, String name) -> {
    return name.endsWith(".txt");
});

当主体代码只有一条语句的时候，括号和return语句也可以省略，上面代码可以变为：
File[] files = f.listFiles((File dir, String name) -> name.endsWith(".txt"));

方法的参数类型声明也可以省略，上面代码还可以继续简化为：
File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));

之所以可以省略方法的参数类型，是因为Java可以自动推断出来，它知道listFiles接受的参数类型是FilenameFilter，这个接口只有一个方法accept，这个方法的两个参数类型分别是File和String。

这样简化下来，代码是不是简洁清楚多了?

排序的代码用Lambda表达式可以写为：
Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));

提交任务的代码用Lambda表达式可以写为：
executor.submit(()->System.out.println("hello"));

参数部分为空，写为()。

当参数只有一个的时候，参数部分的括号可以省略，比如，File还有如下方法：
public File[] listFiles(FileFilter filter)

FileFilter的定义为：
public interface FileFilter {
    boolean accept(File pathname);
}

使用FileFilter重写上面的列举文件的例子，代码可以为：
File[] files = f.listFiles(path -> path.getName().endsWith(".txt"));

变量引用
与匿名内部类类似，Lambda表达式也可以访问定义在主体代码外部的变量，但对于局部变量，它也只能访问final类型的变量，与匿名内部类的区别是，它不要求变量声明为final，但变量事实上不能被重新赋值。比如：
String msg = "hello world";
executor.submit(()->System.out.println(msg));

可以访问局部变量msg，但msg不能被重新赋值，如果这样写：
String msg = "hello world";
msg = "good morning";
executor.submit(()->System.out.println(msg));

Java编译器会提示错误。

这个原因与匿名内部类是一样的，Java会将msg的值作为参数传递给Lambda表达式，为Lambda表达式建立一个副本，它的代码访问的是这个副本，而不是外部声明的msg变量。如果允许msg被修改，则程序员可能会误以为Lambda表达式会读到修改后的值，引起更多的混淆。

为什么非要建副本，直接访问外部的msg变量不行吗？不行，因为msg定义在栈中，当Lambda表达式被执行的时候，msg可能早已被释放了。如果希望能够修改值，可以将变量定义为实例变量，或者，将变量定义为数组，比如：
String[] msg = new String[]{"hello world"};
msg[0] = "good morning";
executor.submit(()->System.out.println(msg[0]));

与匿名内部类比较
从以上内容可以看出，Lambda表达式与匿名内部类很像，主要就是简化了语法，那它是不是语法糖，内部实现其实就是内部类呢？答案是否定的，Java会为每个匿名内部类生成一个类，但Lambda表达式不会，Lambda表达式通常比较短，为每个表达式生成一个类会生成大量的类，性能会受到影响。

Java利用了Java 7引入的为支持动态类型语言引入的invokedynamic指令、方法句柄(method handle)等，具体实现比较复杂，我们就不探讨了，感兴趣可以参看http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html，我们需要知道的是，Java的实现是非常高效的，不用担心生成太多类的问题。

Lambda表达式不是匿名内部类，那它的类型到底是什么呢？是函数式接口。

函数式接口
Java 8引入了函数式接口的概念，函数式接口也是接口，但只能有一个抽象方法，前面提及的接口都只有一个抽象方法，都是函数式接口。之所以强调是"抽象"方法，是因为Java 8中还允许定义其他方法，我们待会会谈到。Lambda表达式可以赋值给函数式接口，比如：
FileFilter filter = path -> path.getName().endsWith(".txt");
FilenameFilter fileNameFilter = (dir, name) -> name.endsWith(".txt");
Comparator<File> comparator = (f1, f2) -> f1.getName().compareTo(f2.getName());
Runnable task = () -> System.out.println("hello world");

如果看这些接口的定义，会发现它们都有一个注解@FunctionalInterface，比如：
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}

@FunctionalInterface用于清晰地告知使用者，这是一个函数式接口，不过，这个注解不是必需的，不加，只要只有一个抽象方法，也是函数式接口。但如果加了，而又定义了超过一个抽象方法，Java编译器会报错，这类似于我们在85节介绍的Override注解。