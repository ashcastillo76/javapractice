package com.ashley.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.mvc.models.Book;
import com.sun.xml.bind.v2.model.core.ID;


@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	// this method retrieves all books
	List<Book> findAll();
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    List<Book> findById(ID id);
  
}
