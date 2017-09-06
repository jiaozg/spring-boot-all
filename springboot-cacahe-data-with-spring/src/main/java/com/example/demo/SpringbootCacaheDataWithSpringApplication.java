package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootCacaheDataWithSpringApplication {

	//在我们不使用其他第三方缓存依赖的时候，springboot自动采用ConcurrenMapCacheManager作为缓存管理器。
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacaheDataWithSpringApplication.class, args);
	}
}
