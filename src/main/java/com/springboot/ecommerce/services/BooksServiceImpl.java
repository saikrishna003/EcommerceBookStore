package com.springboot.ecommerce.services;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.ecommerce.models.Books;
import com.springboot.ecommerce.repositories.BooksRepo;

@Service
public class BooksServiceImpl implements BooksService{

	@Autowired
	private BooksRepo booksRepo;
	
	public List<Books> getAllBooks() {
		return booksRepo.findAll();
	}

	public List<Books> getBooksByAuthors(String authors) {
		return booksRepo.findByAuthorsContainingIgnoreCase(authors);
	}

	public List<Books> getBooksByTitle(String title) {
		return booksRepo.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Books> getBooksByAuthorsAndTitle(String authors, String title) {
		return booksRepo.findByAuthorsContainingIgnoreCaseAndTitleContainingIgnoreCase(authors,title);
	}
	
	public Page<Books> getAllBooks(PageRequest pageRequest) {
		return booksRepo.findAll(pageRequest);
	}

	public Page<Books> getBooksByAuthors(String authors, PageRequest pageRequest) {
		return booksRepo.findByAuthorsContainingIgnoreCase(authors,pageRequest);
	}
	
	public Page<Books> getBooksByTitle(String title, PageRequest pageRequest) {
		return booksRepo.findByTitleContainingIgnoreCase(title,pageRequest);
	}

	public Page<Books> getBooksByAuthorsAndTitle(String authors, String title, PageRequest pageRequest) {
		return booksRepo.findByAuthorsContainingIgnoreCaseAndTitleContainingIgnoreCase(authors,title,pageRequest);
	}
	
	@Override
	public List<Books> getBooks(String authors, String title) {
		List<Books> books;
		if(authors != null && title != null)
			books = this.getBooksByAuthorsAndTitle(authors,title);
		else if(authors != null)
			books = this.getBooksByAuthors(authors);
		else if(title != null)
			books = this.getBooksByTitle(title);
		else
			books = this.getAllBooks();
		return books;
	}
	
	@Override
	public Page<Books> getBooksWithPagination(String authors, String title, PageRequest pageRequest) {
		
		Page<Books> books;
		
		if(authors != null && title != null)
			books = this.getBooksByAuthorsAndTitle(authors,title,pageRequest);
		else if(authors != null)
			books = this.getBooksByAuthors(authors,pageRequest);
		else if(title != null)
			books = this.getBooksByTitle(title,pageRequest);
		else
			books = this.getAllBooks(pageRequest);
		
		return books;
	}
	
	@Override
	public Books getBookByBookId(Integer bookId) {
		return booksRepo.findByBookId(bookId);
	}
	
	@Override
	public List<Books> getBooksByRating(Double minRating,Double maxRating) {
		return booksRepo.findByAverageRatingBetween(minRating-0.001,maxRating+0.001);
	}

	@Override
	public Map<String, Object> getPaginationResponse(Page<Books> books) {
		Map<String, Object> response = new HashMap<>();
		response.put("books", books.getContent());
		response.put("currentPage", books.getNumber());
		response.put("totalItems", books.getTotalElements());
		response.put("totalPages", books.getTotalPages());
		response.put("pageSize",books.getSize());
		return response;
	}

	@Override
	public Books saveBook(@Valid Books book) {
		return booksRepo.save(book);
	}

	@Override
	public Books updateBook(Books book, Books updateBook) {
		Field[] updateBookFields = updateBook.getClass().getDeclaredFields();		
		for(Field field:updateBookFields) {
			field.setAccessible(true);
			try {
                if(field.get(updateBook) != null) 
                	field.set(book, field.get(updateBook));
            } catch (IllegalAccessException e) {
                System.out.println(field.getName() + " is inaccessible");
            }
		}
		return booksRepo.save(book);
	}

	@Override
	public void deleteBook(Integer bookId) {
		booksRepo.deleteByBookId(bookId);
	}

}
