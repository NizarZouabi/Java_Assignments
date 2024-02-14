package com.assignment.relationships.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.relationships.models.License;
import com.assignment.relationships.models.Person;
import com.assignment.relationships.services.LicenseService;
import com.assignment.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private PersonService personService;
	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	
	@GetMapping("/person")
	public String person(@ModelAttribute("person") Person person) {
		return "person.jsp";
	}
	
	@PostMapping("/person/create")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "person.jsp";
		} else {
			personService.addPerson(person);
			return "redirect:/license";
		}
	}
	
	@GetMapping("/license")
	public String license(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	@PostMapping("/license/create")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Person> persons = personService.getAllPersons();
			model.addAttribute("persons", persons);
			String randomnum = UUID.randomUUID().toString().substring(0, 7);
			model.addAttribute("randomnum", randomnum);
			return "license.jsp";
		} else {
			licenseService.addLicense(license);
			return "redirect:/";
		}
	}
}
