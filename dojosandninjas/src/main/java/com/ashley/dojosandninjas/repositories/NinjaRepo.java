package com.ashley.dojosandninjas.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashley.dojosandninjas.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

				List<Ninja> findAll();
				List<Ninja> findByDojoIsNotNull();

			}

		


	
	

