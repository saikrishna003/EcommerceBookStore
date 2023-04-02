package com.springboot.ecommerce.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ecommerce.models.Books;
import com.springboot.ecommerce.services.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllBooks(
			@RequestParam(defaultValue = "false") Boolean isPagination,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "20") Integer size){
		
		Map<String, Object> response = new HashMap<>();
		
		if(isPagination) {
			Page<Books> books = booksService.getAllBooks(PageRequest.of(page, size));
			response.put("books", books.getContent());
			response.put("currentPage", books.getNumber());
			response.put("totalItems", books.getTotalElements());
			response.put("totalPages", books.getTotalPages());
			response.put("pageSize",books.getSize());
		} else {
			response.put("books", booksService.getAllBooks());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{book_id}")
	public List<Books> getBookByBookId(@PathVariable Integer book_id){
		return booksService.getBooksByBookId(book_id);
	}
	
	@GetMapping("/author/{author}")
	public List<Books> getBookByAuthor(@PathVariable String author){
		return booksService.getBooksByAuthors(author);
	}
	
	@GetMapping("/title/{title}")
	public List<Books> getBookByTitle(@PathVariable String title){
		return booksService.getBooksByTitle(title);
	}
	
	@GetMapping("/rating")
	public List<Books> getBookByRating(@RequestParam(defaultValue = "1.0") Double minRating,
			@RequestParam(defaultValue = "5.0") Double maxRating){
		return booksService.getBooksByRating(minRating,maxRating);
	}
}
