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
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public List<Product> productsWithoutCategory(Category category){
		return productRepo.findAllByCategoriesNotContaining(category);
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product oneProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
		    Product existingProduct = optionalProduct.get();
			return existingProduct;
		} else {
			return null;
		}
	}
	
	public Product updateProduct(Long id, Product product) {
		Optional<Product> existingProduct = productRepo.findById(id);
		if(existingProduct.isPresent()) {
			Product updatedProduct = existingProduct.get();
			updatedProduct.setName(product.getName());
			updatedProduct.setDescription(product.getDescription());
			updatedProduct.setPrice(product.getPrice());
			updatedProduct.setCategories(product.getCategories());
			return updatedProduct;
		} else {
			return null;
		}
	}
	
	public void addProductToCategory(Long categoryId, Long productId) {
		Product product = this.oneProduct(productId);
		Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
		if (optionalCategory.isPresent()) {
	        Category existingCategory = optionalCategory.get();
	        if (!product.getCategories().contains(existingCategory)) {
	            product.getCategories().add(existingCategory);
	            productRepo.save(product);
	        }
	    }
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
}
