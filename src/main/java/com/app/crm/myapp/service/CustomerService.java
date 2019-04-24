package com.app.crm.myapp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.crm.myapp.Exception.CustomizedException;
import com.app.crm.myapp.dao.CustomerDaoRepo;
import com.app.crm.myapp.entity.Customer;

@Repository
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDaoRepo customerDaoRepo;
	
	
	//find customers by id
	public Customer findById(Integer id) {
				Optional<Customer> result=customerDaoRepo.findById(id);
				Customer customer=null;
				if(result.isPresent()) {
					customer=result.get();
					return customer;
				}
				else {
					throw new CustomizedException("Customer id does not exist");
				}
					
	}
	
	//get all customers
		public List<Customer> findAll() {
			List<Customer> list=customerDaoRepo.findAll();
			return list;
		}
	
	// insert or update
	public Customer insert(Customer customer) {
		Customer savedCustomer=customerDaoRepo.save(customer);
		return savedCustomer;
	}
	
	public ResponseEntity<Customer> deleteById(Integer id) {
		Optional<Customer> result=customerDaoRepo.findById(id);
		if(result.isPresent()) {
			 customerDaoRepo.deleteById(id);
			 return new ResponseEntity<Customer>(HttpStatus.OK);	
		}
		else {
			throw new CustomizedException("Customer id does not exist or already deleted");
		}					
	}

	public ResponseEntity<Customer> update(Customer customer) {
		int id=customer.getId();
		customerDaoRepo.save(customer);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}

}
