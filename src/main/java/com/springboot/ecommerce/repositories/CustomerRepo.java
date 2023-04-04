package com.springboot.ecommerce.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce.models.Customers;

@Repository
public interface CustomerRepo extends MongoRepository<Customers,ObjectId>{

	Customers findByCustomerId(Integer customerId);

	List<Customers> findByNameStartsWith(String name);
	
	List<Customers> findByNameContainingIgnoreCase(String name);

	void deleteByCustomerId(Integer customerId);
}
