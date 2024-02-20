package com.assignment.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bookclub.models.Book;
import com.assignment.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public Book getBook(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			Book existingBook = book.get();
			return existingBook;
		} else {
			return null;
		}
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Long id, Book book) {
		Optional<Book> optionalBook = bookRepository.findById(id);
	    if (optionalBook.isPresent()) {
	        Book existingBook = optionalBook.get();
	        existingBook.setTitle(book.getTitle());
	        existingBook.setAuthor(book.getAuthor());
	        existingBook.setThoughts(book.getThoughts());
	        return bookRepository.save(existingBook);
	    } else {
	        return null;
	    }
	}
	
	public Book deleteBook(Long id) {
		bookRepository.deleteById(id);
		return null;
	}
}
