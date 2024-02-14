package com.assignment.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {
	List<Person> findAll();
	Long findById(Person id);
	Long deleteById(Person id);
}
