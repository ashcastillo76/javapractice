package com.ashley.prodandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.prodandcategories.models.Product;
import com.ashley.prodandcategories.repositories.ProductRepo;

@Service
public class ProductService {

	// adding the Product repository as a dependency. calls all the methods in the
	// repository
	private final ProductRepo productRepo;

	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	// returns all the Products
	public List<Product> allProducts() {
		return productRepo.findAll();
	}

	// creates a Product
	public Product createProduct(Product d) {
		return productRepo.save(d);
	}

	// retrieves a Product
	public Product findProduct(Long id) {
//			    	in optional checks if present
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
//			        	if present, returns the book
			return optionalProduct.get();
		} else {
			return null;
		}
	}

//			    updates a Product for API only
	public Product updateProduct(Long id, String name) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			Product p = optionalProduct.get();
			p.setName(name);

			return productRepo.save(p);
		} else {
			return null;
		}
	}

//			    update whole object
	public Product updateProductObject(Product p) {
		return productRepo.save(p);
//			    	can also call the create function
	}

//			    deletes a Product
	public Product deleteProduct(Long id) {
		productRepo.deleteById(id);
		return null;

	}

}
