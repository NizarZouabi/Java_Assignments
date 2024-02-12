package com.assignment.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.burgertracker.models.Burger;
import com.assignment.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
		}
	
	public Burger addBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public List<Burger> getAllBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger findBurger(Long Id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(Id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
	public Burger updateBurger(Burger burger) {
		Optional<Burger> optionalBurger = burgerRepository.findById(burger.getId());
		if (optionalBurger.isPresent()) {
			Burger existingBurger = optionalBurger.get();
			existingBurger.setName(burger.getName());
			existingBurger.setRestaurant(burger.getRestaurant());
			existingBurger.setRating(burger.getRating());
			existingBurger.setNotes(burger.getNotes());
			return burgerRepository.save(existingBurger);
		} else {
			return null;
		}
	}
}
