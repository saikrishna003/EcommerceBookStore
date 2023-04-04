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
	public Customers getCustomerByCustomerId(Integer customerId) {
		return customerRepo.findByCustomerId(customerId);
	}

	@Override
	public List<Customers> getCustomersByName(String name) {
		return customerRepo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Customers saveCustomer(Customers customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customers updateCustomer(Customers customer, Customers updateCustomer) {
		if(updateCustomer.getName() != null) customer.setName(updateCustomer.getName());
		if(updateCustomer.getAddress() != null) customer.setAddress(updateCustomer.getAddress());
		if(updateCustomer.getCity() != null) customer.setCity(updateCustomer.getCity());;
		if(updateCustomer.getCountry() != null) customer.setCountry(updateCustomer.getCountry());
		if(updateCustomer.getZipcode() != 0) customer.setZipcode(updateCustomer.getZipcode());
		if(updateCustomer.getState() != null) customer.setState(updateCustomer.getState());
		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepo.deleteByCustomerId(customerId);
	}

}
