package com.sergio.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	@NotNull
	@Size(max=255)
	private String category_name;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="products_categories",
			joinColumns=@JoinColumn(name="category_id"),
			inverseJoinColumns = @JoinColumn(name="product_id")
			)
	private List<Product> products;
	
	public Category () {}
	
	public Category( String category_name) {
		this.category_name = category_name;
		
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
