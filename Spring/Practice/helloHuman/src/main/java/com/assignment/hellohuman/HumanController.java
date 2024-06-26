package com.assignment.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	@RequestMapping("/")
	public String human(@RequestParam(value="first_name", required=false) String firstName, @RequestParam(value="last_name", required=false) String lastName) {
		if(firstName == null && lastName == null) {
			return "Hello Human";
		} else {
			return "Hello " + firstName + " " + lastName;
		}
	}
}
