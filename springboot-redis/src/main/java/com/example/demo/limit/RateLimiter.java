package com.example.demo.limit;

import java.lang.annotation.*;

/**
 * @email wangiegie@gmail.com
 * @data 2017-08
 * 限流注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    int limit() default 5;
    int timeout() default 1000;
}