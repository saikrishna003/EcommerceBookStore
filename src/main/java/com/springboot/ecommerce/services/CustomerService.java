package com.springboot.ecommerce.services;

import java.util.List;

import com.springboot.ecommerce.models.Customers;

public interface CustomerService {

	List<Customers> getAllCustomers();

	Customers getCustomerByCustomerId(Integer customerId);

	List<Customers> getCustomersNameContains(String name);

	Customers saveCustomer(Customers customer);
	
	Customers updateCustomer(Customers customers, Customers updatCustomer);

	void deleteCustomer(Integer customerId);

}
