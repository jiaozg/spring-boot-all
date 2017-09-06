package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbDistributedidApplicationTests {

	Logger logger = LoggerFactory.getLogger(SpringbootMongodbDistributedidApplicationTests.class);

	@Autowired
	CustomerRepository customerRepository;


	@Test
	public void mongodbIdTest(){
		Customer customer=new Customer("lxdxil","dd");
		customer=customerRepository.save(customer);
		logger.info( "mongodbId:"+customer.getId());
	}

}
