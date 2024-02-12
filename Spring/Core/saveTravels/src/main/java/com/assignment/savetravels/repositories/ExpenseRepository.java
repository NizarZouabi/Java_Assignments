package com.assignment.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
	List<Expense> findAll();
	Long findById(Expense id);
	Long deleteById(Expense id);
}
