package com.assignment.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.assignment.burgertracker.models.Burger;
import com.assignment.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.getAllBurgers();
	    model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("/burger")
	public String add(Model model, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			List<Burger> burgers = burgerService.getAllBurgers();
		    model.addAttribute("burgers", burgers);
			return "index.jsp";
		} else {
			burgerService.addBurger(burger);
			return "redirect:/";
		}
	}
	
	@GetMapping("/burger/{id}")
	public String editBurger(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		model.addAttribute("id", id);
		return "edit.jsp";
	}
	
	@PatchMapping("burger/{id}/edit")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
}
