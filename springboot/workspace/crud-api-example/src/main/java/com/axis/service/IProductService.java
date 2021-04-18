package com.axis.service;

import java.util.List;

import com.axis.model.Product;

public interface IProductService {
	
	public List<Product> getAllProducts();

	public Product addProduct(Product product);
	
	public void deleteById(int productId);
}
