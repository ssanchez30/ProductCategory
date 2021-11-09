package com.sergio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.models.Category;
import com.sergio.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.selectAllCategory();
	}

	public Category getCategoryById(Long category_id) {
		return categoryRepository.selectCategoryById(category_id);
	}

	public void registerCategory(String category_name) {

		categoryRepository.insertCategory(category_name);

	}

	public List<Category> catNotSelected(Long product_id) {
		return categoryRepository.catNotSelected(product_id);
	}

}
