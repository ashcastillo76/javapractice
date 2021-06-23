package com.ashley.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ashley.dojooverflow.models.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Long> {

	List<Answer> findAll();

}