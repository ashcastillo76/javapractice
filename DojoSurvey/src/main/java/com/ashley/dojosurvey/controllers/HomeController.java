package com.ashley.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
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
	public String submit(@RequestParam String name, String location, String language, String comment) {
		System.out.println(name);
		System.out.println(location);
		System.out.println(language);
		System.out.println(comment);
		return "redirect:/";
	}
}
