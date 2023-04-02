package com.springboot.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ecommerce.models.Customers;
import com.springboot.ecommerce.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customers> getAllCustomers(){
		return customerService.getAllCustomers(); 
	}
	
	@GetMapping("/{customer_id}")
	public List<Customers> getCustomerByCustomerId(@PathVariable Integer customer_id) {
		return customerService.getCustomerByCustomer_id(customer_id);
	}
	
	@GetMapping("/name/{name}")
	public List<Customers> getCustomersContains(@PathVariable String name){
		return customerService.getCustomersContains(name);
	}
}
