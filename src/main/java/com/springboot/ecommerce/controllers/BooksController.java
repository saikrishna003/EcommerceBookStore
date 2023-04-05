package com.springboot.ecommerce.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
			@RequestParam(defaultValue = "true") Boolean isPagination,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "20") Integer size,
			@RequestParam(required = false) String authors,
			@RequestParam(required = false) String title){
		
		Map<String, Object> response = new HashMap<>();
		
		if(isPagination) {
			PageRequest pageRequest = PageRequest.of(page, size);
			Page<Books> books = booksService.getBooksWithPagination(authors,title,pageRequest);
			
			if(!books.isEmpty()) 
				response = booksService.getPaginationResponse(books);
			else 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} else {
			List<Books> books = booksService.getBooks(authors,title);
		
			if(!books.isEmpty())
				response.put("books", books);
			else 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Books> getBookByBookId(@PathVariable Integer bookId){
		Optional<Books> book = Optional.of(booksService.getBookByBookId(bookId)); 
		return new ResponseEntity<Books>(book.get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Books> saveBook(@Valid @RequestBody Books book){
		Books savedBook = booksService.saveBook(book);
		return new ResponseEntity<Books>(savedBook, HttpStatus.CREATED);
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Books> updateBook(@PathVariable Integer bookId,@RequestBody Books updateBook){
		Optional<Books> getBook = Optional.of(booksService.getBookByBookId(bookId));
		Books updatedBook = booksService.updateBook(getBook.get(),updateBook);
		return new ResponseEntity<Books>(updatedBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
		Optional.of(booksService.getBookByBookId(bookId));
		booksService.deleteBook(bookId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		
	}
//	@GetMapping("/rating")
//	public ResponseEntity<Map<String, Object>> getBookByRating(
//			@RequestParam(defaultValue = "true") Boolean isPagination,
//			@RequestParam(defaultValue = "0") Integer page,
//			@RequestParam(defaultValue = "20") Integer size,
//			@RequestParam(defaultValue = "1.0") Double minRating,
//			@RequestParam(defaultValue = "5.0") Double maxRating){
//		
//		Map<String, Object> response = new HashMap<>();
//		
//		if(isPagination) {
//			Page<Books> books;
//			PageRequest pageRequest = PageRequest.of(page, size);
//			if(!books.isEmpty()) 
//				response = booksService.getPaginationResponse(books);
//			else 
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//			
//		}
//		return booksService.getBooksByRating(minRating,maxRating);
//	}
}
