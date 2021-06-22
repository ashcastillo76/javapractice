package com.ashley.relationships.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashley.relationships.models.Person;
import com.ashley.relationships.services.PersonService;

@RestController
public class PersonsApi {
		private final PersonService personService;

		public PersonsApi(PersonService personService) {
			this.personService = personService;
		}

//			returns all people ("persons")
		@RequestMapping("/api/persons")
		public List<Person> index() {
			return personService.allPersons();
		}

//			  post method
		@RequestMapping(value = "/api/persons", method = RequestMethod.POST)
		public Person create(@RequestParam(value = "FirstName") String FirstName, @RequestParam(value = "LastName") String LastName) {
			Person person = new Person(FirstName, LastName);
			return personService.createPerson(person);
		}

//			    returns a specific person by id
		@RequestMapping("/api/persons/{id}")
		public Person show(@PathVariable("id") Long id) {
			Person person = personService.findPerson(id);
			return person;
		}

//			    a put method for a person to update a person
		@RequestMapping(value = "/api/persons/{id}", method = RequestMethod.PUT)
		public Person update(@PathVariable("id") Long id, @RequestParam(value = "fname") String fname,
				@RequestParam(value = "lname") String lname) {
			Person person = personService.updatePerson(id, fname, lname);
			return person;
		}

//			    deletes a book from the database
		@RequestMapping(value = "/api/persons/{id}/destroy", method = RequestMethod.DELETE)
		public void destroy(@PathVariable("id") Long id) {
			personService.deletePerson(id);
		}

	}

