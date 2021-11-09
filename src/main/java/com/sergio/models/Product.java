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
@Table(name="products")
public class Product {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_id;
	
	@NotNull
	@Size(max =255)
	private String product_name;
	
	@NotNull
	@Size(max = 255)
	private String description;
	
	@NotNull
	private Double price;
	


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="products_categories",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="category_id")
			)
	private List<Category> categories;
	
	public Product () {}
	
	public Product(String product_name, String description, Double price) {
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}
