package com.assignment.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		}
		session.setAttribute("count", count += 1);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session) {
		session.getAttribute("count");
		return "counter.jsp";
	}
}
