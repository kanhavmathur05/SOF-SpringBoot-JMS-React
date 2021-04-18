package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Product;
import com.axis.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	IProductService service;
	
	@GetMapping("/allview")
	public List<Product> viewAllProducts() {
		return service.getAllProducts();
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		service.deleteById(id);
		return "Product Id is deleted";
	}
}
