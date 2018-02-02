package com.example.demo;

import com.example.demo.component.QueueThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringbootMybatisAnnotationApplication implements CommandLineRunner {



	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringbootMybatisAnnotationApplication.class, args);

		new Thread(new QueueThread()).start();

	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}
}
