package com.springboot.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ecommerce.models.Customers;
import com.springboot.ecommerce.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customers>> getAllCustomers(@RequestParam(required = false) String name){
		List<Customers> customers = new ArrayList<>();
		
		if(name == null)
			customerService.getAllCustomers().forEach(customers::add);
		else
			customerService.getCustomersNameContains(name).forEach(customers::add);
		if(customers.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customers> getCustomerByCustomerId(@PathVariable Integer customerId) {
		Optional<Customers> customer = Optional.of(customerService.getCustomerByCustomerId(customerId));
		return new ResponseEntity<Customers>(customer.get(), HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Customers> saveCustomer(@Valid @RequestBody Customers customer){
		Customers savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customers>(savedCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable Integer customerId,@RequestBody Customers updateCustomer){
		Optional<Customers> getCustomer = Optional.of(customerService.getCustomerByCustomerId(customerId));
		Customers updatedCustomer = customerService.updateCustomer(getCustomer.get(),updateCustomer);
		return new ResponseEntity<Customers>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) {
		Optional.of(customerService.getCustomerByCustomerId(customerId));
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		
	}
	
}
