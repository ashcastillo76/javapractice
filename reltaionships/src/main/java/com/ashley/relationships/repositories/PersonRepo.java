package com.ashley.relationships.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.relationships.models.Person;
import com.sun.xml.bind.v2.model.core.ID;


@Repository
public interface PersonRepo extends CrudRepository <Person, Long> {
			// this method retrieves all books
			List<Person> findAll();
		
		  
		    List<Person> findById(ID id);
		  
		}

		


	
	
