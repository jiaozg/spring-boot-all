package com.example.demo;

import com.example.demo.limit.RateLimiter;
import com.example.demo.limit.RedisRateLimiterPlus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@SpringBootApplication
public class SpringbootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisApplication.class, args);
	}


	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
		private Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

		@Autowired
		private JedisPool jedisPool;

		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new HandlerInterceptorAdapter() {
				public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                         Object handler) throws Exception {
					HandlerMethod handlerMethod = (HandlerMethod) handler;
					Method method = handlerMethod.getMethod();
					RateLimiter rateLimiter = method.getAnnotation(RateLimiter.class);

					if (rateLimiter != null) {
						int limit = rateLimiter.limit();
						int timeout = rateLimiter.timeout();
						Jedis jedis = jedisPool.getResource();
						String token = RedisRateLimiterPlus.acquireTokenFromBucket(jedis, method.getName(), limit, timeout);
						if (token == null) {
							response.sendError(500);
							return false;
						}
						logger.debug("token -> {}", token);
						jedis.close();
					}
					return true;
				}
			}).addPathPatterns("/*");
		}
	}

}
