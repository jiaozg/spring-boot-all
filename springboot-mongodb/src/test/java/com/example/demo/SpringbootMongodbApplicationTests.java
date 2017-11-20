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
public class SpringbootMongodbApplicationTests {

	Logger logger = LoggerFactory.getLogger(SpringbootMongodbApplicationTests.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testSavecustomer() throws Exception {
		Customer customer=new Customer();
		customer.setId("2");
		customer.setFirstName("小明");
		customer.setLastName("fffooo123");
		customerRepository.save(customer);
	}

	@Test
	public void findcustomerBycustomerName(){
		Customer customer= customerRepository.findByFirstName("小明");
		System.out.println("customer is "+customer);
	}

	@Test
	public void updatecustomer(){
		Customer customer=new Customer();
		customer.setId("2");
		customer.setFirstName("天空111");
		customer.setLastName("fffxxxx6666");
		customerRepository.save(customer);
	}

//    @Test
//    public void deletecustomerById(){
//        customerDao.deletecustomerById(1l);
//    }

	@Test
	public void mongodbIdTest(){
		Customer customer=new Customer("lxdxil","dd");
		customer=customerRepository.save(customer);
		logger.info( "mongodbId:"+customer.getId());
	}

}
