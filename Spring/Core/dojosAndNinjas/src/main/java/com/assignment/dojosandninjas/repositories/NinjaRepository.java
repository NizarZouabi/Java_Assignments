package com.assignment.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja,Long> {
	List<Ninja> findAll();
	Long findById(Ninja id);
	Long deleteById(Ninja id);
}
