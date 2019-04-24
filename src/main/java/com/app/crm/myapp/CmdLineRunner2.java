package com.app.crm.myapp;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.crm.myapp.dao.CustomerDaoRepo;

import com.app.crm.myapp.entity.Customer;


@Component
public class CmdLineRunner2 implements CommandLineRunner{
	
	
	public static final Logger log=org.slf4j.LoggerFactory.getLogger(CmdLineRunner2.class);
		
	@Autowired
	CustomerDaoRepo customerDaoRepo;

	@Override
	public void run(String... args) throws Exception {
		Customer customer1= new Customer("Anil","Kumar","anil123@gmail.com");
		customerDaoRepo.save(customer1);
		
		Customer customer2= new Customer("Sunil","Verma","sunil.verma@gmail.com");
		customerDaoRepo.save(customer2);
		
		Customer customer3= new Customer("Raj","Kumar","rajcool@gmail.com");
		customerDaoRepo.save(customer3);
		
		Customer customer4= new Customer("Akshay","Tripathi","akshayrocks@gmail.com");
		customerDaoRepo.save(customer4);
		
		Customer customer5= new Customer("Piyush","Goyal","piyushgoyal@gmail.com");
		customerDaoRepo.save(customer5);
		
	}

}
