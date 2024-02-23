package com.assignment.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.productsandcategories.models.Category;
import com.assignment.productsandcategories.models.Product;
import com.assignment.productsandcategories.repositories.CategoryRepo;
import com.assignment.productsandcategories.repositories.ProductRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public List<Category> categoriesWithoutProduct(Product product){
		return categoryRepo.findAllByProductsNotContaining(product);
	}
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category oneCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
		    Category existingCategory = optionalCategory.get();
			return existingCategory;
		} else {
			return null;
		}
	}
	
	public Category updateCategory(Long id, Category category) {
		Optional<Category> existingCategory = categoryRepo.findById(id);
		if(existingCategory.isPresent()) {
			Category updatedCategory = existingCategory.get();
			updatedCategory.setName(category.getName());
			updatedCategory.setProducts(category.getProducts());
			return updatedCategory;
		} else {
			return null;
		}
	}
	
    public void addCategoryOfProduct(Long productId, Long categoryId) {
    	Category category = this.oneCategory(categoryId);
		Optional<Product> optionalProduct = productRepo.findById(productId);
		if(optionalProduct.isPresent()) {
			Product existingProduct = optionalProduct.get();
			if(!category.getProducts().contains(existingProduct)) {
				category.getProducts().add(existingProduct);
			    categoryRepo.save(category);
		   }
		}
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
}
