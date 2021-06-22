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

import com.ashley.dojosandninjas.models.Ninja;
import com.ashley.dojosandninjas.services.NinjaService;
import com.ashley.dojosandninjas.services.DojoService;

@Controller
public class NinjaController {

	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
				this.ninjaService = ninjaService;
				this.dojoService = dojoService;
			}

//			redirect for "/"
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/ninjas/new";
	}

//			    shows all ninjas
	@RequestMapping("/ninjas")
	public String index(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "/ninjas/index.jsp";
	}

//			    form for a new ninja
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "/ninjas/new.jsp";
	}

//			    post method
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos";
		}
	}

//			show
	@RequestMapping(value = "/ninjas/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "/ninjas/show.jsp";
	}

//			    edit ninja
	@RequestMapping("/ninjas/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "/ninjas/edit.jsp";
	}

	// put request to update edit
	@RequestMapping(value = "/ninjas/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/ninjas/edit.jsp";
		} else {
			ninjaService.updateNinjaObject(ninja);
			return "redirect:/ninjas";
		}

	}

//			    delete request
	@RequestMapping(value = "/ninjas/{id}/destroy", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/ninjas";
	}
}
