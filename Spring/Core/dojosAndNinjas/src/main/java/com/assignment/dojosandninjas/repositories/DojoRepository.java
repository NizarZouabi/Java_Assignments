package com.assignment.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo,Long> {
	List<Dojo> findAll();
	Long findById(Dojo id);
	Long deleteById(Dojo id);
}
