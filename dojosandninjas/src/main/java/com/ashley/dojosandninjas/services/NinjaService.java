package com.ashley.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ashley.dojosandninjas.models.Ninja;
import com.ashley.dojosandninjas.repositories.NinjaRepo;


@Service
public class NinjaService {
			// adding the ninja repository as a dependency. calls all the methods in the
			// repository
			private final NinjaRepo ninjaRepo;

			public NinjaService(NinjaRepo ninjaRepo) {
				this.ninjaRepo = ninjaRepo;
			}

			// returns all the ninjas
			public List<Ninja> allNinjas() {
				return ninjaRepo.findAll();
			}
			
			public List<Ninja> ninjasInDojos(){
				return ninjaRepo.findByDojoIsNotNull();
			}

			// creates a ninja
			public Ninja createNinja(Ninja n) {
				return ninjaRepo.save(n);
			}

			// retrieves a ninja
			public Ninja findNinja(Long id) {
//			    	in optional checks if present
				Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
				if (optionalNinja.isPresent()) {
//			        	if present, returns the book
					return optionalNinja.get();
				} else {
					return null;
				}
			}

//			    updates a dojo for API only
			public Ninja updateNinja(Long id, String firstName, String lastName, int age) {
				Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
				if (optionalNinja.isPresent()) {
					Ninja n = optionalNinja.get();
					n.setFirstName(firstName);
					n.setLastName(lastName);
					n.setAge(age);

					return ninjaRepo.save(n);
				} else {
					return null;
				}
			}

//			    update whole object
			public Ninja updateNinjaObject(Ninja n) {
				return ninjaRepo.save(n);
//			    	can also call the create function
			}

//			    deletes a ninja
			public Ninja deleteNinja(Long id) {
				ninjaRepo.deleteById(id);
				return null;

			}

			public void save(@Valid Ninja ninja) {
				ninjaRepo.save(ninja);

			}
		}

		
		

	
	

