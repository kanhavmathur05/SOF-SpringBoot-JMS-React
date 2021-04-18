package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
