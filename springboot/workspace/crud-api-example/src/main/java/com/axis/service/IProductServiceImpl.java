package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.Product;
import com.axis.repository.IProductRepository;

@Service
public class IProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository repo;
	
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public void deleteById(int productId) {
		repo.deleteById(productId);
	}

}
