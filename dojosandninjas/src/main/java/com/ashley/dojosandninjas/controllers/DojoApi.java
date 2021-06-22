package com.ashley.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashley.dojosandninjas.models.Dojo;

import com.ashley.dojosandninjas.services.DojoService;


@RestController
public class DojoApi {
		private final DojoService dojoService;

		public DojoApi(DojoService dojoService) {
			this.dojoService = dojoService;
		}

//			returns all Dojos
		@RequestMapping("/api/dojos")
		public List<Dojo> index() {
			return dojoService.allDojos();
		}

//			  post method
		@RequestMapping(value = "/api/dojos", method = RequestMethod.POST)
		public Dojo create(@RequestParam(value = "name") String name) {
			Dojo dojo = new Dojo(name);
			return dojoService.createDojo(dojo);
		}

//			    returns a specific book by id
		@RequestMapping("/api/dojos/{id}")
		public Dojo show(@PathVariable("id") Long id) {
			Dojo dojo = dojoService.findDojo(id);
			return dojo;
		}

//			    a put method for a book to update a book
		@RequestMapping(value = "/api/dojos/{id}", method = RequestMethod.PUT)
		public Dojo update(@PathVariable("id") Long id, @RequestParam(value = "name") String name) {
			Dojo dojo = dojoService.updateDojo(id, name);
			return dojo;
		}

//			    deletes a book from the database
		@RequestMapping(value = "/api/dojos/{id}/destroy", method = RequestMethod.DELETE)
		public void destroy(@PathVariable("id") Long id) {
			dojoService.deleteDojo(id);
		}

	}

	

