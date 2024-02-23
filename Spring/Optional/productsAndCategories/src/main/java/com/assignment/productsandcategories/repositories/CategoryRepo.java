package com.assignment.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.productsandcategories.models.Category;
import com.assignment.productsandcategories.models.Product;

public interface CategoryRepo extends CrudRepository<Category,Long> {
	List<Category> findAll();
	List<Category> findAllByProductsNotContaining(Product product);
	Long findById(Category id);
	Long deleteById(Category id);
}
