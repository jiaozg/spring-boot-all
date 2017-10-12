函数式数据处理，针对常见的集合数据处理，Java 8引入了一套新的类库，
位于包java.util.stream下，称之为Stream API

使用Stream API，代码可以这样：
List<Student> above90List = students.stream()
        .filter(t->t.getScore()>90)
        .collect(Collectors.toList());

先通过stream()得到一个Stream对象，然后调用Stream上的方法，filter()过滤得到90分以上的，它的返回值依然是一个Stream，为了转换为List，调用了collect方法并传递了一个Collectors.toList()，表示将结果收集到一个List中。

代码更为简洁易读了，这种数据处理方式被称为函数式数据处理，与传统代码相比，它的特点是：
没有显式的循环迭代，循环过程被Stream的方法隐藏了
提供了声明式的处理函数，比如filter，它封装了数据过滤的功能，而传统代码是命令式的，需要一步步的操作指令
流畅式接口，方法调用链接在一起，清晰易读

使用Stream API，可以将基本函数filter()和map()结合起来，代码可以这样：
List<String> above90Names = students.stream()
        .filter(t->t.getScore()>90)
        .map(Student::getName)
        .collect(Collectors.toList());

这种组合利用基本函数、声明式实现集合数据处理功能的编程风格，就是函数式数据处理。

代码更为直观易读了，但你可能会担心它的性能有问题。filter()和map()都需要对流中的每个元素操作一次，一起使用会不会就需要遍历两次呢？答案是否定的，只需要一次。实际上，调用filter()和map()都不会执行任何实际的操作，它们只是在构建操作的流水线，调用collect才会触发实际的遍历执行，在一次遍历中完成过滤、转换以及收集结果的任务。

像filter和map这种不实际触发执行、用于构建流水线、返回Stream的操作被称为中间操作(intermediate operation)，而像collect这种触发实际执行、返回具体结果的操作被称为终端操作(terminal operation)。Stream API中还有更多的中间和终端操作，下面我们具体来看下。


中间操作
除了filter和map，Stream API的中间操作还有distinct, sorted, skip, limit, peek, mapToLong, mapToInt, mapToDouble, flatMap等

终端操作
中间操作不触发实际的执行，返回值是Stream，而终端操作触发执行，返回一个具体的值，除了collect，Stream API的终端操作还有max, min, count, allMatch, anyMatch, noneMatch, findFirst, findAny, forEach, toArray, reduce等

allMatch/anyMatch/noneMatch
这几个函数都接受一个谓词Predicate，返回一个boolean值，用于判定流中的元素是否满足一定的条件，它们的区别是：
allMatch: 只有在流中所有元素都满足条件的情况下才返回true
anyMatch: 只要流中有一个元素满足条件就返回true
noneMatch: 只有流中所有元素都不满足条件才返回true