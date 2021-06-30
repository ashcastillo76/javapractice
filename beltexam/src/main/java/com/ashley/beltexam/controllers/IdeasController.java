package com.ashley.beltexam.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashley.beltexam.models.Idea;
import com.ashley.beltexam.services.IdeasService;
import com.ashley.beltexam.services.UserService;



@Controller
public class IdeasController {

	@Autowired
	private IdeasService ideasService;

	@Autowired
	private UserService userService;


//		redirect for "/"
		@RequestMapping("/")
		public String redirect() {
			return "redirect:/ideas";
		}

//		    shows all ideas
		@RequestMapping("/ideas")
		public String index(Model model) {
			List<Idea> idea = ideasService.allIdeas();
			model.addAttribute("ideas", new Idea());
			model.addAttribute("idea", idea);
			return "/ideas/homePage.jsp";
		}

//		    form for a new idea
		@RequestMapping("/ideas/new")
		public String newIdea(@ModelAttribute("idea") Idea idea, Model model, @HttpSession session) {
			session.getAttribute("user");
			return "/ideas/new.jsp";
		}

//		    post method
		@RequestMapping(value = "/ideas/new", method = RequestMethod.POST)
		public String create(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
			if (result.hasErrors()) {
				System.out.println(result);
				return "/ideas/new.jsp";
			} else {
				ideasService.createIdea(idea);
				return "redirect:homePage.jsp";
			}
		}

//		show
		@RequestMapping(value = "/ideas/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			Idea idea = ideasService.findIdea(id);
			model.addAttribute("idea", idea);
			return "/ideas/show.jsp";
		}

//		    edit language
		@RequestMapping("/ideas/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
			Idea idea = ideasService.findIdea(id);
			model.addAttribute("idea", idea);
			return "/ideas/edit.jsp";
		}

	//put request to update edit
		@RequestMapping(value = "/ideas/{id}/edit", method = RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model) {
			if (result.hasErrors()) {
				System.out.println(result);
				return "/ideas/edit.jsp";
			} else {
				ideasService.updateIdeaObject(idea);
				return "redirect:/ideas";
			}

		}

//		    delete request
		@RequestMapping(value = "/ideas/{id}/destroy", method = RequestMethod.DELETE)
		public String destroy(@PathVariable("id") Long id) {
			ideasService.deleteIdea(id);
			return "redirect:/ideas";
		}
	}


