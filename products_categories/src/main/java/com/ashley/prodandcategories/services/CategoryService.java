package com.ashley.prodandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.prodandcategories.models.Category;
import com.ashley.prodandcategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	// adding the Category repository as a dependency. calls all the methods in the
	// repository
	private final CategoryRepo categoryRepo;

	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	// returns all the Categories
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	// creates a Category
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}

	// retrieves a Category
	public Category findCategory(Long id) {
//		    	in optional checks if present
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
//		        	if present, returns the book
			return optionalCategory.get();
		} else {
			return null;
		}
	}

//		    updates a Category for API only
	public Category updateCategory(Long id, String name) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			Category c = optionalCategory.get();
			c.setName(name);

			return categoryRepo.save(c);
		} else {
			return null;
		}
	}

//		    update whole object
	public Category updateCategoryObject(Category c) {
		return categoryRepo.save(c);
//		    	can also call the create function
	}

//		    deletes a Category
	public Category deleteCategory(Long id) {
		categoryRepo.deleteById(id);
		return null;

	}

}
