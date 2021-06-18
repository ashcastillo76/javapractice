package com.ashley.relationships.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashley.relationships.models.Person;
import com.ashley.relationships.models.License;
import com.ashley.relationships.services.PersonService;

@Controller
public class PersonsController {
		private final personService personService;

		public PersonsController(PersonService personService) {
			this.personService = personService;
		}

//		redirect for "/"
		@RequestMapping("/")
		public String redirect() {
			return "redirect:/persons";
		}
		
//		    shows all languages
		@RequestMapping("/persons")
		public String index(Model model) {
			List<Person> language = personService.allPersons();
			model.addAttribute("persons", new Person());
			model.addAttribute("person", person);
			return "/persons/index.jsp";
		}

//		    form new language
		@RequestMapping("/persons/new")
		public String newPerson(@ModelAttribute("person") Person person) {
			return "/persons/index.jsp";
		}

//		    post method
		@RequestMapping(value = "/persons", method = RequestMethod.POST)
		public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
			if (result.hasErrors()) {
				return "/persons/index.jsp";
			} else {
				personService.createPerson(person);
				return "redirect:/persons";
			}
		}

		@RequestMapping(value = "/persons/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			Person person = personService.findPerson(id);
			model.addAttribute("person", person);
			return "/persons/show.jsp";
		}

//		    edit language
		@RequestMapping("/persons/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
			Person person = personService.findPerson(id);
			model.addAttribute("person", person);
			return "/persons/edit.jsp";
		}

	//put request to update edit
		@RequestMapping(value = "/persons/{id}/edit", method = RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model){
			if (result.hasErrors()) {
				return "/persons/edit.jsp";
			} else {
				personService.updatePersonObject(person);
				return "redirect:/persons";
			}

		}

//		    delete request
		@RequestMapping(value = "/persons/{id}/destroy", method = RequestMethod.DELETE)
		public String destroy(@PathVariable("id") Long id) {
			personService.deletePerson(id);
			return "redirect:/persons";
		}
	}

	
	
	
	
	
	
}
