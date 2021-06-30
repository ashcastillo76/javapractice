package com.ashley.beltexam.services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.ashley.beltexam.models.Idea;
import com.ashley.beltexam.repositories.IdeaRepo;

@Service
public class IdeasService {

		// adding the idea repository as a dependency. calls all the methods in the
		// repository
		private final IdeaRepo ideaRepo;

		public IdeasService(IdeaRepo ideaRepo) {
			this.ideaRepo = ideaRepo;
		}

		// returns all the ideas
		public List<Idea> allIdeas() {
			return ideaRepo.findAll();
		}

		// creates a idea
		public Idea createIdea(Idea l) {
			return ideaRepo.save(l);
		}

		// retrieves a idea
		public Idea findIdea(Long id) {
//		    	in optional checks if present
			Optional<Idea> optionalIdea = ideaRepo.findById(id);
			if (optionalIdea.isPresent()) {
//		        	if present, returns the book
				return optionalIdea.get();
			} else {
				return null;
			}
		}


//		    update whole object
		public Idea updateIdeaObject(Idea l) {
			return ideaRepo.save(l);
//		    	can also call the create function
		}

//		    deletes a idea
		public Idea deleteIdea(Long id) {
			ideaRepo.deleteById(id);
			return null;

		}

		public void save(@Valid Idea idea) {
			ideaRepo.save(idea);

		}
	}

	
	