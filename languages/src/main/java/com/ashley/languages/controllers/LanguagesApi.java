package com.ashley.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashley.languages.models.Language;
import com.ashley.languages.services.LanguageService;

@RestController
public class LanguagesApi {

	private final LanguageService languageService;

	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}

//		returns all languages
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return languageService.allLanguages();
	}

//		  post method
	@RequestMapping(value = "/api/languages", method = RequestMethod.POST)
	public Language create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
			@RequestParam(value = "version") Double version) {
		Language language = new Language(name, creator, version);
		return languageService.createLanguage(language);
	}

//		    returns a specific book by id
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		return language;
	}

//		    a put method for a book to update a book
	@RequestMapping(value = "/api/languages/{id}", method = RequestMethod.PUT)
	public Language update(@PathVariable("id") Long id, @RequestParam(value = "name") String name,
			@RequestParam(value = "creator") String creator, @RequestParam(value = "version") Double version) {
		Language language = languageService.updateLanguage(id, name, creator, version);
		return language;
	}

//		    deletes a book from the database
	@RequestMapping(value = "/api/languages/{id}/destroy", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
	}

}
