package com.assignment.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.savetravels.models.Expense;
import com.assignment.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public Expense getExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
	public Expense updateExpense(Expense expense) {
		Optional<Expense> optionalExpense = expenseRepository.findById(expense.getId());
		if (optionalExpense.isPresent()) {
			Expense existingExpense = optionalExpense.get();
			existingExpense.setName(expense.getName());
			existingExpense.setVendor(expense.getVendor());
			existingExpense.setAmount(expense.getAmount());
			existingExpense.setDescription(expense.getDescription());
			return expenseRepository.save(existingExpense);
		} else {
			return null;
		}
	}
}
