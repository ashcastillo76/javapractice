package com.ashley.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.languages.models.Language;
import com.sun.xml.bind.v2.model.core.ID;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {

	// this method retrieves all books
	List<Language> findAll();


}
