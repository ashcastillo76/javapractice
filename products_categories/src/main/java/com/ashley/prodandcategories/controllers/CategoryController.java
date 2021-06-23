package com.ashley.prodandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashley.prodandcategories.models.Category;
import com.ashley.prodandcategories.models.Product;
import com.ashley.prodandcategories.services.CategoryService;
import com.ashley.prodandcategories.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

//		    shows all Categories
	@RequestMapping("/categories")
	public String index(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "/categories/showAll.jsp";
	}

//		    form for a new Category
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		model.addAttribute("categories", categoryService.allCategories());
		return "/categories/new.jsp";
	}

//		    post method to create a category
	@RequestMapping(value = "/categories/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories";
		}
	}

//		show
	@RequestMapping(value = "/categories/{category_id}")
		public String show(@PathVariable("category_id") Long category_id, Model model) {
			model.addAttribute("products", productService.allProducts());
			model.addAttribute("category", categoryService.findCategory(category_id));
			return "/categories/showOne.jsp";
		}

//		    edit Category
	@RequestMapping("/Categories/{category_id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		return "/categories/edit.jsp";
	}

//		post request to add product to a category
	@RequestMapping(value = "/categories/{category_id}/edit", method = RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("category_id") Long category_id,
			@RequestParam("product_id") Long product_id) {

		Category myCategory = categoryService.findCategory(category_id);
		Product myProduct = productService.findProduct(product_id);

		myCategory.getProducts().add(myProduct);
		categoryService.updateCategoryObject(myCategory);

		return "redirect:/categories/" + category_id;
	}

	// put request to update edit
	@RequestMapping(value = "/categories/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("Category") Category category, BindingResult result, Model model,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/categories/edit.jsp";
		} else {
			categoryService.updateCategoryObject(category);
			return "redirect:/categories";
		}

	}

//		    delete request
	@RequestMapping(value = "/categories/{id}/destroy", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/categories";
	}
}
