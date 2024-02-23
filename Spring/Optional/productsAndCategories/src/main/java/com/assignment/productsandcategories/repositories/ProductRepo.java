package com.assignment.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.productsandcategories.models.Category;
import com.assignment.productsandcategories.models.Product;

public interface ProductRepo extends CrudRepository<Product,Long> {
	List<Product> findAll();
	List<Product> findAllByCategoriesNotContaining(Category category);
	Long findById(Product id);
	Long deleteById(Product id);
}
