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

//	redirect for "/"
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}

//	    shows all languages
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> language = languageService.allLanguages();
		model.addAttribute("languages", new Language());
		model.addAttribute("language", language);
		return "/languages/index.jsp";
	}

//	    form for a new language
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Language language) {
		return "/languages/index.jsp";
	}

//	    post method
	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

//	show
	@RequestMapping(value = "/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}

//	    edit language
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}

//put request to update edit
	@RequestMapping(value = "/languages/{id}/edit", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "/languages/edit.jsp";
		} else {
			languageService.updateLanguageObject(language);
			return "redirect:/languages";
		}

	}

//	    delete request
	@RequestMapping(value = "/languages/{id}/destroy", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
