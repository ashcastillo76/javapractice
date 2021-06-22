package com.ashley.relationships.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ashley.relationships.models.Person;
import com.ashley.relationships.repositories.PersonRepo;


@Service
public class PersonService {
			 // adding the person repository as a dependency. calls all the methods in the repository
		    private final PersonRepo personRepo;
		    
		    public PersonService(PersonRepo personRepo) {
		        this.personRepo = personRepo;
		    }
		    // returns all the persons
		    public List<Person> allPersons() {
		        return personRepo.findAll();
		    }
		    // creates a person
		    public Person createPerson(Person p) {
		        return personRepo.save(p);
		    }
		    
		    // retrieves a language
		    public Person findPerson(Long id) {
//		    	in optional checks if present
		        Optional<Person> optionalPerson = personRepo.findById(id);
		        if(optionalPerson.isPresent()) {
//		        	if present, returns the person
		            return optionalPerson.get();
		        } else {
		            return null;
		        }
		    }
//		    updates a person for API only
		    public Person updatePerson(Long id, String fname, String lname) {
		        Optional<Person> optionalPerson = personRepo.findById(id);
		        if(optionalPerson.isPresent()) {
		            Person person = optionalPerson.get();
		            person.setFirstName(fname);
		            person.setLastName(lname);
		   
		          
		            return personRepo.save(person);
		        } else {
		            return null;
		        }
		    }
		    
//		    update whole object
		    public Person updatePersonObject(Person p) {
		    	return personRepo.save(p);
//		    	can also call the create function
		    }
		    
//		    deletes a language
		    public Person deletePerson(Long id) {
		         personRepo.deleteById(id);
		         return null;
		    
		    }
			public void save(@Valid Person person) {
				personRepo.save(person);
				
			}
		}


		
		


	

