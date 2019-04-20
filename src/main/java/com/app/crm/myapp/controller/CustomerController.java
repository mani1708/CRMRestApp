package com.app.crm.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.crm.myapp.entity.Customer;
import com.app.crm.myapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> get(@PathVariable Integer id) {
		return customerService.findById(id);
	}
	
	
	@PostMapping("/customers")
	public Customer insert(@RequestBody Customer customer) {
		return customerService.insert(customer) ;
	}

	//get all customers
	@GetMapping("/customers")
	public List<Customer> findAll() {			
	return customerService.findAll();
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteById(@PathVariable Integer id) {	
		return customerService.deleteById(id);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {	
		return customerService.update(customer);
	}
	
	
	
}
