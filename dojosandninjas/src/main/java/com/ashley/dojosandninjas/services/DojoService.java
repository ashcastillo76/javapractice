package com.ashley.dojosandninjas.services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ashley.dojosandninjas.models.Dojo;
import com.ashley.dojosandninjas.repositories.DojoRepo;


@Service
public class DojoService {
		// adding the dojo repository as a dependency. calls all the methods in the
		// repository
		private final DojoRepo dojoRepo;

		public DojoService(DojoRepo dojoRepo) {
			this.dojoRepo = dojoRepo;
		}

		// returns all the dojos
		public List<Dojo> allDojos() {
			return dojoRepo.findAll();
		}
		

		// creates a dojo
		public Dojo createDojo(Dojo d) {
			return dojoRepo.save(d);
		}

		// retrieves a dojo
		public Dojo findDojo(Long id) {
//		    	in optional checks if present
			Optional<Dojo> optionalDojo = dojoRepo.findById(id);
			if (optionalDojo.isPresent()) {
//		        	if present, returns the book
				return optionalDojo.get();
			} else {
				return null;
			}
		}

//		    updates a dojo for API only
		public Dojo updateDojo(Long id, String name) {
			Optional<Dojo> optionalDojo = dojoRepo.findById(id);
			if (optionalDojo.isPresent()) {
				Dojo d = optionalDojo.get();
				d.setName(name);

				return dojoRepo.save(d);
			} else {
				return null;
			}
		}

//		    update whole object
		public Dojo updateDojoObject(Dojo d) {
			return dojoRepo.save(d);
//		    	can also call the create function
		}

//		    deletes a dojo
		public Dojo deleteDojo(Long id) {
			dojoRepo.deleteById(id);
			return null;

		}

		public void save(@Valid Dojo dojo) {
			dojoRepo.save(dojo);

		}
	}

	
	
