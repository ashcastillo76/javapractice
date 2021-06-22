package com.ashley.prodandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.prodandcategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();


}
