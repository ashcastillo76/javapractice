package com.ashley.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashley.dojosandninjas.models.Dojo;
import com.ashley.dojosandninjas.models.Ninja;
import com.ashley.dojosandninjas.services.DojoService;
import com.ashley.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

//		    shows all dojos
	@RequestMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojo = dojoService.allDojos();
		model.addAttribute("dojos", dojo);
		return "/dojos/index.jsp";
	}

//		    form for a new dojo
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "/dojos/new.jsp";
	}

//		    post method
	@RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}

//		show
	@RequestMapping(value = "/dojos/{id}")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		model.addAttribute("ninja", ninjaService.ninjasInDojos());
		return "/dojos/show.jsp";
	}


//		    edit dojo
	@RequestMapping("/dojos/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/edit.jsp";
	}

	// put request to update edit
	@RequestMapping(value = "/dojos/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/dojos/edit.jsp";
		} else {
			dojoService.updateDojoObject(dojo);
			return "redirect:/dojos";
		}

	}

//		    delete request
	@RequestMapping(value = "/dojos/{id}/destroy", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/dojos";
	}
}
