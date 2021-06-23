package com.ashley.dojooverflow.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.dojooverflow.models.Question;
import com.ashley.dojooverflow.repositories.QuestionRepo;

@Service
public class QuestionService {

		// adding the Question repository as a dependency. calls all the methods in the
		// repository
		private final QuestionRepo questionRepo;

		public QuestionService(QuestionRepo questionRepo) {
			this.questionRepo = questionRepo;
		}

		// returns all the Questions
		public List<Question> allQuestions() {
			return questionRepo.findAll();
		}

		// creates a Question
		public Question createQuestion(Question d) {
			return questionRepo.save(d);
		}

		// retrieves a Question
		public Question findQuestion(Long id) {
//				    	in optional checks if present
			Optional<Question> optionalQuestion = questionRepo.findById(id);
			if (optionalQuestion.isPresent()) {
//				        	if present, returns the book
				return optionalQuestion.get();
			} else {
				return null;
			}
		}

////				    updates a Question for API only
//		public Question updateQuestion(Long id, String question) {
//			Optional<Question> optionalQuestion = questionRepo.findById(id);
//			if (optionalQuestion.isPresent()) {
//				Question q = optionalQuestion.get();
//				q.setQuestion(question);
//
//				return questionRepo.save(q);
//			} else {
//				return null;
//			}
//		}

//				    update whole object
		public Question updateQuestionObject(Question q) {
			return questionRepo.save(q);
//				    	can also call the create function
		}

//				    deletes a Question
		public Question deleteQuestion(Long id) {
			questionRepo.deleteById(id);
			return null;

		}

	}

	
	