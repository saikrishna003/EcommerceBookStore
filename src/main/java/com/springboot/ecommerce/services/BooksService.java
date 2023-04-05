package com.springboot.ecommerce.services;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.springboot.ecommerce.models.Books;

public interface BooksService {

	List<Books> getBooks(String authors, String title);
	
	Page<Books> getBooksWithPagination(String authors, String title, PageRequest pageRequest);
	
	Books getBookByBookId(Integer bookId);
	
	List<Books> getBooksByRating(Double minRating,Double maxRating);

	Map<String, Object> getPaginationResponse(Page<Books> books);

	Books saveBook(@Valid Books book);

	Books updateBook(Books book, Books updateBook);

	void deleteBook(Integer bookId);

	

}
