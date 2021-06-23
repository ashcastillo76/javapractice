package com.ashley.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ashley.dojooverflow.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long> {

	List<Question> findAll();

}
