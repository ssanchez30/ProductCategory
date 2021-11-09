package com.sergio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.models.ProductCategory;
import com.sergio.repositories.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	private final ProductCategoryRepository productCategoryRepository;

	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}

	public void registerProductCategory(Long category_id, Long product_id) {

		productCategoryRepository.insertProductCategory(category_id, product_id);
	}

	public List<ProductCategory> selectAllProductCategory() {
		return productCategoryRepository.selectAllProductCategory();
	}

	public List<ProductCategory> selectAllCategoryProduct() {
		return productCategoryRepository.selectAllCategoryProduct();
	}

}
