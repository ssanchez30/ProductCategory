package com.sergio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sergio.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "SELECT * FROM products", nativeQuery = true)
	List<Product> selectAllProducts();

	@Query(value = "SELECT * FROM products WHERE product_id=?1", nativeQuery = true)
	Product selectProductById(Long product_id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO products( product_name, description, price) "
			+ "VALUES(?1, ?2, ?3)", nativeQuery = true)
	void insertProduct(String product_name, String description, Double price);

	@Query(value = "SELECT * FROM products p WHERE p.product_id NOT IN (SELECT pc.product_id FROM products_categories pc WHERE pc.category_id= ?1)", nativeQuery = true)
	List<Product> prodNotSelected(Long categorty_id);
}
