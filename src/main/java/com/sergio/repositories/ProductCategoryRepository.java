package com.sergio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sergio.models.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO products_categories(category_id, product_id) " + "VALUES(?1, ?2)", nativeQuery = true)
	void insertProductCategory(Long category_id, Long product_id);

	@Query(value = "SELECT * FROM products_categories", nativeQuery = true)
	List<ProductCategory> selectAllProductCategory();

	@Query(value = "SELECT * FROM products_categories", nativeQuery = true)
	List<ProductCategory> selectAllCategoryProduct();

}
