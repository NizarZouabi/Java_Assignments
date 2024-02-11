package com.assignment.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.mvc.models.Book;
import com.assignment.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if (optionalBook.isPresent()) {
    		Book getAndRemove = optionalBook.get();
    		bookRepository.deleteById(id);
    		return getAndRemove;
    	} else {
    		return null;
    	}
    }
    public Book updateBook(Long id, String title, String desc, String language, Integer pages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		Book bookInDb = optionalBook.get();
    		bookInDb.setTitle(title);
    		bookInDb.setDescription(desc);
    		bookInDb.setLanguage(language);
    		bookInDb.setNumberOfPages(pages);
    		return bookRepository.save(bookInDb);
    	} else {
    		return null;
    	}
    }
}
