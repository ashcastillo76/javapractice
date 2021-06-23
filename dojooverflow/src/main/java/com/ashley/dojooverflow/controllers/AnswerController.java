package com.ashley.dojooverflow.controllers;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.ashley.dojooverflow.models.Answer;
import com.ashley.dojooverflow.models.Question;
import com.ashley.dojooverflow.services.QuestionService;
import com.ashley.dojooverflow.services.AnswerService;

@Controller
public class AnswerController {

		@Autowired
		private AnswerService answerService;

		@Autowired
		private QuestionService questionService;

//			    shows all answers
		@RequestMapping("/answers")
		public String index(Model model) {
			List<Answer> answers = answerService.allAnswers();
			model.addAttribute("answers", answers);
			return "/answers/showAll.jsp";
		}

//			    form for a new Category
		@RequestMapping("/answers/new")
		public String newCategory(@ModelAttribute("answer") Answer answer, Model model) {
			model.addAttribute("answers", answerService.allAnswers());
			return "/answers/new.jsp";
		}

//			    post method to create a answer
		@RequestMapping(value = "/answers/new", method = RequestMethod.POST)
		public String create(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
			if (result.hasErrors()) {
				return "/answers/new.jsp";
			} else {
				answerService.createAnswer(answer);
				return "redirect:/questions";
			}
		}

//			show
		@RequestMapping(value = "/answers/{answer_id}")
			public String show(@PathVariable("answer_id") Long answer_id, Model model) {
				model.addAttribute("questions", questionService.allQuestions());
				model.addAttribute("answer", answerService.findAnswer(answer_id));
				return "/answers/showOne.jsp";
			}

//			    edit Category
		@RequestMapping("/answers/{answer_id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
			Answer answer = answerService.findAnswer(id);
			model.addAttribute("answer", answer);
			return "/answers/edit.jsp";
		}

////			post request to add product to a answer
//		@RequestMapping(value = "/answers/{answer_id}/edit", method = RequestMethod.POST)
//		public String addAnswerToQuestion(@PathVariable("answer_id") Long answer_id,
//				@RequestParam("question_id") Long question_id) {
//
//			Answer myAnswer = answerService.findAnswer(answer_id);
//			Question myQuestion = questionService.findQuestion(question_id);
//
//			myAnswer.getQuestion().add(myQuestion);
//			answerService.updateAnswerObject(myAnswer);
//
//			return "redirect:/answers/" + answer_id;
//		}

		// put request to update edit
		@RequestMapping(value = "/answers/{id}/edit", method = RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model,
				@PathVariable("id") Long id) {
			if (result.hasErrors()) {
				return "/answers/edit.jsp";
			} else {
				answerService.updateAnswerObject(answer);
				return "redirect:/answers";
			}

		}

//			    delete request
		@RequestMapping(value = "/answers/{id}/destroy", method = RequestMethod.DELETE)
		public String destroy(@PathVariable("id") Long id) {
			answerService.deleteAnswer(id);
			return "redirect:/answers";
		}
	}

	
	
	

