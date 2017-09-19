package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by jiaozhiguang on 2017/9/15.
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
}
