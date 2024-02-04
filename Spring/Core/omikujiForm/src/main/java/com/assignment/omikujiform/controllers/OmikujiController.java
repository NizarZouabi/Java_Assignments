package com.assignment.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	
	@RequestMapping("/omikuji/submit")
	public String submit(
			@RequestParam(value="num") int num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="profession") String profession,
			@RequestParam(value="creature") String creature,
			@RequestParam(value="txt") String txt,
			HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("profession", profession);
		session.setAttribute("creature", creature);
		session.setAttribute("txt", txt);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String omikuji() {
		return "omikuji.jsp";
	}
}
