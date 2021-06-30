package com.ashley.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.beltexam.models.Idea;


	@Repository
	public interface IdeaRepo extends CrudRepository<Idea, Long> {

		// this method retrieves all books
		List<Idea> findAll();


	}
	
	