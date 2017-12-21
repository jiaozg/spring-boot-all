package com.example.demo.pattern.singleton.enumimpl;

/**
 * Created by jiaozhiguang on 2017/12/15.
 *
 * 此方法无偿提供了序列化机制，绝对防止多次实例化，及时面对复杂的序列化或者反射攻击。
 * 单元素枚举类型已经成为实现Singleton的最佳方法。
 *
 * 很多人会对枚举法实现的单例模式很不理解。这里需要深入理解的是两个点：

 枚举类实现其实省略了private类型的构造函数
 枚举类的域(field)其实是相应的enum类型的一个实例对象
 */
public enum Singleton {
    INSTANCE;
}
