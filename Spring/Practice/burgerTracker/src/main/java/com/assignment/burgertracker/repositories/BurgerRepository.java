package com.assignment.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.burgertracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
	Long findById(Burger id);
}
