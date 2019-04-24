package com.app.crm.myapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.crm.myapp.entity.Customer;
import com.app.crm.myapp.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers/{id}")
	public Resource<Customer> findById(@PathVariable Integer id) {
		Customer c=customerService.findById(id);
		Resource<Customer> resource=new Resource<Customer>(c);
		
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).findAll());
		resource.add(link.withRel("all-users"));
		return resource;
		
		
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<Object> insert(@Valid @RequestBody Customer customer) {
		Customer cust= customerService.insert(customer);
		int id=cust.getId();
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id).toUri();
		
		
		return ResponseEntity.created(uri).build();
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
