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
public class CategoriesController {

	private final CategoryService categoryService;
	private final ProductService productService;
	private final ProductCategoryService productCategoryService;

	public CategoriesController(CategoryService categoryService, ProductService productService,
			ProductCategoryService productCategoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.productCategoryService = productCategoryService;
	}

	@RequestMapping(value = "/add/category", method = RequestMethod.GET)
	public String addCategory() {

		return "createCategory.jsp";
	}

	@RequestMapping(value = "/create/category", method = RequestMethod.POST)
	public String createProduct(@RequestParam(value = "category_name") String category_name,
			RedirectAttributes redirectAttributes) {

		categoryService.registerCategory(category_name);

		redirectAttributes.addFlashAttribute("errorMessage", "Category added successfully!!").addFlashAttribute("clase",
				"success");

		return "redirect:/";

	}

	@RequestMapping(value = "/catAdd/{product_id}", method = RequestMethod.GET)
	public String displayCatAdd(@PathVariable("product_id") Long product_id, Model model) {

		Product currentProduct = productService.getProductById(product_id);
		List<Category> listOfCategories = categoryService.getAllCategories();

		List<ProductCategory> listProductCategory = productCategoryService.selectAllProductCategory();

		List<Category> listCatNotSelected = categoryService.catNotSelected(product_id);

		model.addAttribute("currentProduct", currentProduct);
		model.addAttribute("listOfCategories", listOfCategories);
		model.addAttribute("listProductCategory", listProductCategory);
		model.addAttribute("listCatNotSelected", listCatNotSelected);

		return "addProductToCategory.jsp";
	}

	@RequestMapping(value = "/agregarProd/{category_id}", method = RequestMethod.POST)
	public String addCatProd(@PathVariable("category_id") Long category_id,
			@RequestParam(value = "prodSelected") Long prodSelected, Model model) {

		productCategoryService.registerProductCategory(category_id, prodSelected);

		String categoryId = String.valueOf(category_id);

		return "redirect:/prodAdd/" + categoryId;
	}

}
