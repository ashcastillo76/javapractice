package com.ashley.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashley.dojosandninjas.models.Ninja;
import com.ashley.dojosandninjas.services.NinjaService;


@RestController
public class NinjaApi {
			private final NinjaService ninjaService;

			public NinjaApi(NinjaService ninjaService) {
				this.ninjaService = ninjaService;
			}

//				returns all ninjas
			@RequestMapping("/api/ninjas")
			public List<Ninja> index() {
				return ninjaService.allNinjas();
			}

//				  post method
			@RequestMapping(value = "/api/ninjas", method = RequestMethod.POST)
			public Ninja create(@RequestParam(value = "firstName") String firstName, @RequestParam(value="lastName")String lastName, @RequestParam(value="age")int age) {
				Ninja ninja = new Ninja(firstName, lastName, age);
				return ninjaService.createNinja(ninja);
			}

//				    returns a specific ninja by id
			@RequestMapping("/api/ninjas/{id}")
			public Ninja show(@PathVariable("id") Long id) {
				Ninja ninja = ninjaService.findNinja(id);
				return ninja;
			}

//				    a put method for a ninja to update a ninja
			@RequestMapping(value = "/api/ninjas/{id}", method = RequestMethod.PUT)
			public Ninja update(@PathVariable("id") Long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "age") int age) {
				Ninja ninja = ninjaService.updateNinja(id, firstName, lastName, age);
				return ninja;
			}

//				    deletes a ninja from the database
			@RequestMapping(value = "/api/ninjas/{id}/destroy", method = RequestMethod.DELETE)
			public void destroy(@PathVariable("id") Long id) {
				ninjaService.deleteNinja(id);
			}

		}

		


	
	
