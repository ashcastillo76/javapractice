package com.ashley.prodandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.prodandcategories.models.Product;

@Repository
public interface ProductRepo  extends CrudRepository<Product, Long> {

	List<Product> findAll();


}
