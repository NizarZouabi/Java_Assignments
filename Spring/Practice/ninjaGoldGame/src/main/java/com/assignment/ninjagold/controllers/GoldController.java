package com.assignment.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class GoldController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		Integer gold = (Integer) session.getAttribute("gold");
		if (gold == null) {
			session.setAttribute("gold", 0);
		}
		if (activities == null) {
			session.setAttribute("activities", activities = new ArrayList<String>());
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/farm")
	public String goldFarm(HttpSession session) {
		Date date = new Date();
		Random randomize = new Random();
		Integer moreGold = randomize.nextInt(11) + 10;
		Integer gold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", gold += moreGold);
		String success = String.format("You entered a farm and earned %d gold. (%s)", moreGold, date);
		
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(success);
		session.setAttribute("activities", activities);
		
		return "redirect:/";
	}
	
	@RequestMapping("/cave")
	public String goldCave(HttpSession session) {
		Date date = new Date();
		Random randomize = new Random();
		Integer moreGold = randomize.nextInt(6) + 5;
		Integer gold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", gold += moreGold);
		String success = String.format("You entered a cave and earned %d gold. (%s)", moreGold, date);
		
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(success);
		session.setAttribute("activities", activities);
		
		return "redirect:/";
	}
	
	@RequestMapping("/house")
	public String goldHouse(HttpSession session) {
		Date date = new Date();
		Random randomize = new Random();
		Integer moreGold = randomize.nextInt(4) + 2;
		Integer gold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", gold += moreGold);
		String success = String.format("You entered a house and earned %d gold. (%s)", moreGold, date);
		
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add(success);
		session.setAttribute("activities", activities);
		
		return "redirect:/";
	}
	
	@RequestMapping("/quest")
	public String goldQuest(HttpSession session) {
		Date date = new Date();
		Random randomize = new Random();
		Integer rand = randomize.nextInt(2);
		Integer amountOfGold = randomize.nextInt(51);
		String fail = String.format("You entered a quest and lost %d gold. (%s)", amountOfGold, date);
		String success = String.format("You entered a quest and earned %d gold. (%s)", amountOfGold, date);
		
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		
		if (rand == 1) {
			session.setAttribute("gold", gold += amountOfGold);
			activities.add(success);
			session.setAttribute("activities", activities);
		} else {
			session.setAttribute("gold", gold - amountOfGold);
			if (gold - amountOfGold < 0) {
				activities.add(fail);
				String fail2 = String.format("You are in debt.");
				activities.add(fail2);
				session.setAttribute("activities", activities);
			} else {
				activities.add(fail);
				session.setAttribute("activities", activities);
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/clear")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
