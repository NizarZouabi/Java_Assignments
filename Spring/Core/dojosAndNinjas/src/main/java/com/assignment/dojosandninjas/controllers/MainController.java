package com.assignment.dojosandninjas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.dojosandninjas.models.Dojo;
import com.assignment.dojosandninjas.models.Ninja;
import com.assignment.dojosandninjas.services.DojoService;
import com.assignment.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "dashboard.jsp";
	}
	
	@GetMapping("/dojo")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninja";
		}
	}
	
	@GetMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "newninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{dojoId}/details")
	public String dojoDetails(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojodetails.jsp";
	}

}
