package com.springboot.ecommerce.services;

import java.util.List;

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
	
	@Override
	public List<Books> getAllBooks() {
		return booksRepo.findAll();
	}
	
	@Override
	public Page<Books> getAllBooks(PageRequest of) {
		return booksRepo.findAll(of);
	}

	@Override
	public List<Books> getBooksByBookId(Integer book_id) {
		return booksRepo.findByBookId(book_id);
	}

	@Override
	public List<Books> getBooksByAuthors(String author) {
		return booksRepo.findByAuthorsContainingIgnoreCase(author);
	}

	@Override
	public List<Books> getBooksByTitle(String title) {
		return booksRepo.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public List<Books> getBooksByRating(Double minRating,Double maxRating) {
		return booksRepo.findByAverageRatingBetween(minRating-0.001,maxRating+0.001);
	}


}
