package com.springboot.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ecommerce.models.Customers;
import com.springboot.ecommerce.repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customers> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public List<Customers> getCustomerByCustomer_id(Integer customer_id) {
		return customerRepo.findByCustomerId(customer_id);
	}

	@Override
	public List<Customers> getCustomersStartsWith(String name) {
		return customerRepo.findByNameStartsWith(name);
	}

	@Override
	public List<Customers> getCustomersContains(String name) {
		return customerRepo.findByNameContainingIgnoreCase(name);
	}

}
