package com.springboot.ecommerce.services;

import java.util.List;

import com.springboot.ecommerce.models.Customers;

public interface CustomerService {

	List<Customers> getAllCustomers();

	List<Customers> getCustomerByCustomer_id(Integer customer_id);

	List<Customers> getCustomersStartsWith(String name);

	List<Customers> getCustomersContains(String name);

}
