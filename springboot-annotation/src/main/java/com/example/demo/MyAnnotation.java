package com.example.demo;

import java.lang.annotation.*;

/**
 * Created by jiaozhiguang on 2017/9/20.
 *
 * @Target （注解可以作用的目标）
选项：（详见java.lang.annotation.ElementType）

ElementType.TYPE 类、接口（包括注解）、枚举
ElementType. FIELD 字段（包括枚举常量）
ElementType. METHOD 方法
ElementType. PARAMETER 参数
ElementType. CONSTRUCTOR 构造方法
ElementType. LOCAL_VARIABLE 局部变量
ElementType. ANNOTATION_TYPE 注解
ElementType. PACKAGE 包
ElementType. TYPE_PARAMETER 类型参数[ jdk1.8]
ElementType. TYPE_USE 类型使用[ jdk1.8]
注：当注解未指定Target值时，此注解可以使用任何元素之上

 @Retention （注解可以作用的目标）
 选项：（详见java.lang.annotation.RetentionPolicy）

 RetentionPolicy.SOURCE 仅保留在源码，会被编译器丢弃。
 RetentionPolicy.CLASS 仅保留在编译后的class文件中（默认值）。
 RetentionPolicy.RUNTIME 注解保留在编译后的class文件中，并且运行时保留在JVM中，因此可以通过反射获取。
 @Inherited （允许子类继承父类中的注解）

 @Documented （注解会被javadoc处理，javadoc默认不包括注解）

 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
    String test() default "default value";
}

