package com.ashley.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ashley.dojooverflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long> {

	List<Tag> findAll();



}
