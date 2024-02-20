package com.assignment.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
	Long findById(Book id);
	List<Book> findAll();
	Long deleteById(Book id);
}
