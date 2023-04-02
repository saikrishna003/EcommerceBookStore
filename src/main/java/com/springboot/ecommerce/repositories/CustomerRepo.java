package com.springboot.ecommerce.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce.models.Customers;

@Repository
public interface CustomerRepo extends MongoRepository<Customers,Object>{

	@Query("{customer_id:?0}")
	List<Customers> findByCustomerId(Integer customer_id);

	List<Customers> findByNameStartsWith(String name);
	
	List<Customers> findByNameContainingIgnoreCase(String name);
}
