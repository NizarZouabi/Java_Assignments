package com.assignment.productsandcategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.productsandcategories.models.Category;
import com.assignment.productsandcategories.models.Product;
import com.assignment.productsandcategories.services.CategoryService;
import com.assignment.productsandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productService.allProducts();
	    List<Category> categories = categoryService.allCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "home.jsp";
	}
	
	
	@GetMapping("/product/new")
	public String prodcut(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		} else {
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/category/new")
	public String category(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		} else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/product/{productId}")
	public String productToCategory(@PathVariable("productId") Long productId, @ModelAttribute("product") Product product, Model model) {
		Product product1 = productService.oneProduct(productId);
	    List<Category> unjoinedCategories = categoryService.categoriesWithoutProduct(product1);
		model.addAttribute("product", product1);
		model.addAttribute("unjoinedCategories", unjoinedCategories);
		return "product.jsp";
	}
	
	@PutMapping("/product/{productId}/add")
	public String addProduct(@PathVariable("productId") Long productId, @ModelAttribute("product") Product product, @RequestParam(value="id") Long categoryId, Model model) {
			productService.addProductToCategory(categoryId, productId);
			return "redirect:/";
	}
	
	
	@GetMapping("/category/{categoryId}")
	public String categoryOfProduct(@PathVariable("categoryId") Long categoryId, @ModelAttribute("category") Category category, Model model) {
		Category category1 = categoryService.oneCategory(categoryId);
		List<Product> unjoinedProducts = productService.productsWithoutCategory(category1);
		model.addAttribute("category", category1);
		model.addAttribute("unjoinedProducts", unjoinedProducts);
		return "category.jsp";
	}
	
	@PutMapping("/category/{categoryId}/add")
	public String addCategory(@PathVariable("categoryId") Long categoryId, @ModelAttribute("category") Category category, @RequestParam(value="id") Long productId, Model model) {
			categoryService.addCategoryOfProduct(productId, categoryId);
			return "redirect:/";
	}
}
