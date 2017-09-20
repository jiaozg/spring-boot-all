package com.example.demo.actionlog;

import java.lang.annotation.*;

/**
 * Created by jiaozhiguang on 2017/9/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface ActionLog {
    String action() default "default action";
}
