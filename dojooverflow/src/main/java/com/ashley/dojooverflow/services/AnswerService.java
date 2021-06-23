package com.ashley.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.dojooverflow.models.Answer;
import com.ashley.dojooverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
		// adding the Answer repository as a dependency. alls all the methods in the
		// repository
		private final AnswerRepo answerRepo;

		public AnswerService(AnswerRepo answerRepo) {
			this.answerRepo = answerRepo;
		}

		// returns all the Categories
		public List<Answer> allAnswers() {
			return answerRepo.findAll();
		}

		// creates an Answer
		public Answer createAnswer(Answer a) {
			return answerRepo.save(a);
		}

		// retrieves a Answer
		public Answer findAnswer(Long id) {
//			    	in optional checks if present
			Optional<Answer> optionalAnswer = answerRepo.findById(id);
			if (optionalAnswer.isPresent()) {
//			        	if present, returns the book
				return optionalAnswer.get();
			} else {
				return null;
			}
		}

////			    updates a Answer for API only
//		public Answer updateAnswer(Long id, String answer) {
//			Optional<Answer> optionalAnswer = answerRepo.findById(id);
//			if (optionalAnswer.isPresent()) {
//				Answer a = optionalAnswer.get();
//				a.setAnswer(answer);
//
//				return answerRepo.save(a);
//			} else {
//				return null;
//			}
//		}

//			    update whole object
		public Answer updateAnswerObject(Answer a) {
			return answerRepo.save(a);
//			    	can also call the create function
		}

//			    deletes a Answer
		public Answer deleteAnswer(Long id) {
			answerRepo.deleteById(id);
			return null;

		}

	}

	
	