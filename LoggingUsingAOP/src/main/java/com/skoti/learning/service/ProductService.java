package com.skoti.learning.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skoti.learning.entity.Product;
import com.skoti.learning.reposotiry.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void intiDB() {
		productRepository.saveAll(Stream.of(new Product(101, "Book", 499), new Product(102, "laptop", 78000)).collect(Collectors.toList()));
	}
	
	public List<Product> addProduct(List<Product> products) {
		return  (List<Product>) productRepository.saveAll(products);
	}
	
	
	public List<Product> findAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
}
