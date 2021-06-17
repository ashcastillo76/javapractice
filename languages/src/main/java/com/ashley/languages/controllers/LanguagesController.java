package com.ashley.languages.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashley.languages.models.Language;
import com.ashley.languages.services.LanguageService;


@Controller
public class LanguagesController {

	    private final LanguageService languageService;
	    
	    public LanguagesController(LanguageService languageService) {
	        this.languageService = languageService;
	    }
	    
//	    shows all languages
	    @RequestMapping("/languages")
	    public String index(Model model) {
	        List<Language> languages = languageService.allLanguages();
	        model.addAttribute("languages", languages);
	        return "/languages/index.jsp";
	    }
	    
//	    form new language
	    @RequestMapping("/languages/new")
	    public String newLanguage(@ModelAttribute("language") Language language) {
	        return "/languages/new.jsp";
	    }
	    
//	    post method
	    @RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/new.jsp";
	        } else {
	            languageService.createLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    
	    @RequestMapping(value="/languages/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Language language = languageService.findLanguage(id);
	    	model.addAttribute("language", language);
	    	return "/languages/show.jsp";
	    }
	}

	
	
	

