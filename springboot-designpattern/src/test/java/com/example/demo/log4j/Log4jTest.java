package com.example.demo.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Log4jTest {


	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void test() throws Exception {

		for(int i=0;i<10;i++) {
			logger.info("爬虫");
			logger.info("输出info  ");
			logger.debug("输出debug+skkkw嗡嗡嗡kw");
			logger.error("输出error  嗡嗡嗡我");
		}
	}

}
