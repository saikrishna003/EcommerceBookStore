package com.springboot.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.springboot.ecommerce.models.Books;

public interface BooksService {

	List<Books> getAllBooks();

	List<Books> getBooksByBookId(Integer book_id);

	List<Books> getBooksByAuthors(String author);

	List<Books> getBooksByTitle(String title);

	List<Books> getBooksByRating(Double minRating,Double maxRating);

	Page<Books> getAllBooks(PageRequest of);

}
