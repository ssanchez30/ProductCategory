package com.sergio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.models.Product;
import com.sergio.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.selectAllProducts();
	}

	public Product getProductById(Long product_id) {
		return productRepository.selectProductById(product_id);
	}

	public void registerProduct(String product_name, String description, Double price) {

		productRepository.insertProduct(product_name, description, price);

	}

	public List<Product> prodNotSelected(Long category_id) {
		return productRepository.prodNotSelected(category_id);
	}

}
