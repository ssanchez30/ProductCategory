package com.sergio.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sergio.models.Category;
import com.sergio.models.Product;
import com.sergio.models.ProductCategory;
import com.sergio.services.CategoryService;
import com.sergio.services.ProductCategoryService;
import com.sergio.services.ProductService;

@Controller
public class ProductsController {

	private final ProductService productService;
	private final CategoryService categoryService;
	private final ProductCategoryService productCategoryService;

	public ProductsController(ProductService productService, CategoryService categoryService,
			ProductCategoryService productCategoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.productCategoryService = productCategoryService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayMain(Model model) {

		List<Product> listOfProducts = productService.getAllProducts();
		List<Category> listOfCategories = categoryService.getAllCategories();

		model.addAttribute("listOfProducts", listOfProducts);
		model.addAttribute("listOfCategories", listOfCategories);

		return "index.jsp";
	}

	@RequestMapping(value = "/add/product", method = RequestMethod.GET)
	public String addproduct() {

		return "createProduct.jsp";
	}

	@RequestMapping(value = "/create/product", method = RequestMethod.POST)
	public String createProduct(@RequestParam(value = "product_name") String product_name,
			@RequestParam(value = "description") String description, @RequestParam(value = "price") Double price,
			RedirectAttributes redirectAttributes) {

		productService.registerProduct(product_name, description, price);

		redirectAttributes.addFlashAttribute("errorMessage", "Product added successfully!!").addFlashAttribute("clase",
				"success");

		return "redirect:/";

	}

	@RequestMapping(value = "/prodAdd/{category_id}", method = RequestMethod.GET)
	public String displayProdAdd(@PathVariable("category_id") Long category_id, Model model) {

		Category currentCategory = categoryService.getCategoryById(category_id);
		List<Product> listOfProducts = productService.getAllProducts();

		List<ProductCategory> listCategoryProduct = productCategoryService.selectAllCategoryProduct();

		List<Product> listProdNotSelected = productService.prodNotSelected(category_id);

		model.addAttribute("currentCategory", currentCategory);
		model.addAttribute("listOfProducts", listOfProducts);

		model.addAttribute("listCategoryProduct", listCategoryProduct);
		model.addAttribute("listProdNotSelected", listProdNotSelected);

		return "categoryToProduct.jsp";
	}

	@RequestMapping(value = "/agregarCateg/{product_id}", method = RequestMethod.POST)
	public String addProdCat(@PathVariable("product_id") Long product_id,
			@RequestParam(value = "catSelected") Long catSelected, Model model) {

		productCategoryService.registerProductCategory(catSelected, product_id);

		String productoId = String.valueOf(product_id);

		return "redirect:/catAdd/" + productoId;
	}

}
