package com.assignment.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.savetravels.models.Expense;
import com.assignment.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.getAllExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expense/{id}/details")
	public String index(@PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
		Expense expensedetails = expenseService.getExpense(id);
		model.addAttribute("expense", expensedetails);
		return "details.jsp";
	}
	
	@PostMapping("/expense")
	public String create(@Valid @ModelAttribute Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.getAllExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getExpense(id);
		if (id != null) {
			model.addAttribute("expense", expense);
			model.addAttribute("id", id);
			return "edit.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PatchMapping("/expense/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/expense/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
}
