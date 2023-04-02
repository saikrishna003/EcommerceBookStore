package com.springboot.ecommerce.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce.models.Books;

@Repository
public interface BooksRepo extends MongoRepository<Books,Object>{

	List<Books> findByBookId(Integer book_id);

	List<Books> findByAuthorsContainingIgnoreCase(String author);

	List<Books> findByTitleContainingIgnoreCase(String title);

	List<Books> findByAverageRatingBetween(Double minRating, Double maxRating);

}
