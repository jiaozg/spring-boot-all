package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jiaozhiguang on 2017/11/3.
 */

@Target(ElementType.TYPE) //注解运行在那里
@Retention(RetentionPolicy.RUNTIME)
public @interface MyController {
}
