package com.app.crm.myapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.crm.myapp.dao.CustomerDaoRepo;
import com.app.crm.myapp.entity.Customer;

@Repository
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDaoRepo customerDaoRepo;
	
	
	//find customers by id
	public Optional<Customer> findById(Integer id) {
		Optional<Customer> customer=customerDaoRepo.findById(id);
		return customer;
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
		List<Customer> list=customerDaoRepo.findAll();
		int size=list.size();
		if(id==null || id>size) {
			return new ResponseEntity<Customer>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		else {
			customerDaoRepo.deleteById(id);
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		
	}

	public ResponseEntity<Customer> update(Customer customer) {
		int id=customer.getId();
		customerDaoRepo.save(customer);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}

}
