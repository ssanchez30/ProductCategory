package com.sergio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sergio.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	@Query(value = "SELECT * FROM categories", nativeQuery = true)
	List<Category> selectAllCategory();

	@Query(value = "SELECT * FROM categories WHERE category_id=?1", nativeQuery = true)
	Category selectCategoryById(Long category_id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO categories( category_name) " + "VALUES(?1)", nativeQuery = true)
	void insertCategory(String category_name);

	@Query(value = "SELECT * FROM categories c WHERE c.category_id NOT IN (SELECT pc.category_id FROM products_categories pc WHERE pc.product_id= ?1)", nativeQuery = true)
	List<Category> catNotSelected(Long product_id);

}
