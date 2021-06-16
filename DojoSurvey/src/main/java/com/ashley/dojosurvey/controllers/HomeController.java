package com.ashley.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	@RequestMapping("/")
		public String main() {
		return "index.jsp";
	}
	

	@RequestMapping(path="/submit", method= RequestMethod.POST)
	public String submit(@RequestParam String name, String location, String language, String comment, HttpSession session) {
		if(language == "Java") {
			return "redirect:/java";
		}else {
		System.out.println(name);
		System.out.println(location);
		System.out.println(language);
		System.out.println(comment);
		
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		
		return "redirect:/results";
		}
	}
	@RequestMapping("/results")
	public String results(HttpSession session, Model model) {
		String name = (String) session.getAttribute("name");
		model.addAttribute("name", name);
		String location = (String) session.getAttribute("location");
		model.addAttribute("location", location);
		String language = (String) session.getAttribute("language");
		model.addAttribute("language", language);
		String comment = (String) session.getAttribute("comment");
		model.addAttribute("comment", comment);
		
		return "results.jsp";
	}
	@RequestMapping("/java")
	public String java(){
		return "java.jsp";
	}
}
