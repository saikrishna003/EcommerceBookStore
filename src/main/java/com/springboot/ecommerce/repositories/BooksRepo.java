package com.springboot.ecommerce.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce.models.Books;

@Repository
public interface BooksRepo extends MongoRepository<Books,ObjectId>{

	Books findByBookId(Integer bookId);

	List<Books> findByAuthorsContainingIgnoreCase(String authors);

	List<Books> findByTitleContainingIgnoreCase(String title);

	List<Books> findByAverageRatingBetween(Double minRating, Double maxRating);

	List<Books> findByAuthorsContainingIgnoreCaseAndTitleContainingIgnoreCase(String authors, String title);

	Page<Books> findByAuthorsContainingIgnoreCase(String authors, PageRequest pageRequest);

	Page<Books> findByTitleContainingIgnoreCase(String title, PageRequest pageRequest);

	Page<Books> findByAuthorsContainingIgnoreCaseAndTitleContainingIgnoreCase(String authors, String title,
			PageRequest pageRequest);

	void deleteByBookId(Integer bookId);

}
