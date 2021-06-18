package com.ashley.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ashley.languages.models.Language;
import com.ashley.languages.repositories.LanguageRepo;


@Service
public class LanguageService {

		 // adding the language repository as a dependency. calls all the methods in the repository
	    private final LanguageRepo languageRepo;
	    
	    public LanguageService(LanguageRepo languageRepo) {
	        this.languageRepo = languageRepo;
	    }
	    // returns all the languages
	    public List<Language> allLanguages() {
	        return languageRepo.findAll();
	    }
	    // creates a language
	    public Language createLanguage(Language l) {
	        return languageRepo.save(l);
	    }
	    
	    // retrieves a language
	    public Language findLanguage(Long id) {
//	    	in optional checks if present
	        Optional<Language> optionalLanguage = languageRepo.findById(id);
	        if(optionalLanguage.isPresent()) {
//	        	if present, returns the book
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
//	    updates a language for API only
	    public Language updateLanguage(Long id, String name, String creator, Double version) {
	        Optional<Language> optionalLanguage = languageRepo.findById(id);
	        if(optionalLanguage.isPresent()) {
	            Language language = optionalLanguage.get();
	            language.setName(name);
	            language.setCreator(creator);
	            language.setVersion(version);
	          
	            return languageRepo.save(language);
	        } else {
	            return null;
	        }
	    }
	    
//	    update whole object
	    public Language updateLanguageObject(Language l) {
	    	return languageRepo.save(l);
//	    	can also call the create function
	    }
	    
//	    deletes a language
	    public Language deleteLanguage(Long id) {
	         languageRepo.deleteById(id);
	         return null;
	    
	    }
		public void save(@Valid Language language) {
			languageRepo.save(language);
			
		}
	}


	
	

