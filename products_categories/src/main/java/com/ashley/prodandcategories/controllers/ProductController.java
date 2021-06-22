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

import com.ashley.prodandcategories.models.Product;
import com.ashley.prodandcategories.services.CategoryService;
import com.ashley.prodandcategories.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

//	redirect for "/"
	@RequestMapping("/")
	public String entry() {
		return "redirect:/products";
	}

//	    shows all Products
	@RequestMapping("/products")
	public String index(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "/products/index.jsp";
	}

//	    form for a new Product
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("categories", categoryService.allCategories());
		return "/products/new.jsp";
	}

//	    post method
	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products";
		}
	}

//	show
	@RequestMapping(value = "/products/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return "/products/show.jsp";
	}

//	    edit Product
	@RequestMapping("/products/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return "/products/edit.jsp";
	}

// put request to update edit
	@RequestMapping(value = "/products/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/products/edit.jsp";
		} else {
			productService.updateProductObject(product);
			return "redirect:/products";
		}

	}

//	    delete request
	@RequestMapping(value = "/products/{id}/destroy", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
}
