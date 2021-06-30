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
import com.ashley.dojooverflow.models.Tag;
import com.ashley.dojooverflow.services.AnswerService;
import com.ashley.dojooverflow.services.QuestionService;
import com.ashley.dojooverflow.services.TagService;



@Controller
public class QuestionController {
		
		@Autowired
		private QuestionService questionService;
		
		@Autowired
		private AnswerService answerService;
		
		@Autowired
		private TagService tagService;

//		redirect for "/"
		@RequestMapping("/")
		public String entry() {
			return "redirect:/questions";
		}

//		    shows all questions
		@RequestMapping("/questions")
		public String index(Model model) {
			List<Question> questions = questionService.allQuestions();
			model.addAttribute("questions", questions);
			return "/questions/showAll.jsp";
		}

//		    form for a new Question
		@RequestMapping("/questions/new")
		public String newQuestion(@ModelAttribute("question") Question question, Model model) {
			model.addAttribute("questions", questionService.allQuestions());
			return "/questions/new.jsp";
		}

//		    post method
		@RequestMapping(value = "/questions/new", method = RequestMethod.POST)
		public String create(@Valid @ModelAttribute("question") Question question, BindingResult result, @RequestParam("question_id") Long question_id, @RequestParam("tag_id")Long tag_id) {
			if (result.hasErrors()) {
				return "/questions/new.jsp";
			}else {
				questionService.createQuestion(question);
				Question myQuestion = questionService.findQuestion(question_id);
				Tag myTag = tagService.findTag(tag_id);

				question.getTags().add(myTag);
				questionService.updateQuestionObject(question);
//				tagService.createTag(tags);
				return "redirect:/questions";
			}
		}

//		show
		@RequestMapping(value = "/questions/{question_id}")
		public String show(@ModelAttribute("answer") Answer answer, @PathVariable("question_id") Long question_id, Model model ) {
			model.addAttribute("question", questionService.findQuestion(question_id));
			model.addAttribute("answers", answerService.allAnswers());
			return "/questions/showOne.jsp";
		}

//		    edit Question and add to answer
		@RequestMapping(value ="/questions/{question_id}/edit", method=RequestMethod.POST)
		public String addToanswer(@PathVariable("question_id") Long question_id, @RequestParam("answer_id") Long answer_id) {
			Question myQuestion = questionService.findQuestion(question_id);
			Answer myAnswer = answerService.findAnswer(answer_id);
			
			myQuestion.getAnswers().add(myAnswer);
			questionService.updateQuestionObject(myQuestion);
		
			return "redirect:/questions/" + question_id ;
		}
		
////		post request to add tag to a question
//	@RequestMapping(value = "/questions/{question_id}/tags/edit", method = RequestMethod.POST)
//	public String addTagToQuestion(@PathVariable("question_id") Long question_id,
//			@RequestParam("tag_id") Long tag_id) {
//		Question myQuestion = questionService.findQuestion(question_id);
//		Tag myTag = tagService.findTag(tag_id);
//	
//
//		myQuestion.getTags().add(myTag);
//		questionService.updateQuestionObject(myQuestion);
//
//		return "redirect:/questions/" + question_id;
//	}
	


	// put request to update edit
		@RequestMapping(value = "/questions/{question_id}/edit", method = RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("question") Question question, BindingResult result, Model model,
				@PathVariable("id") Long id) {
			if (result.hasErrors()) {
				return "/questions/edit.jsp";
			} else {
				questionService.updateQuestionObject(question);
				return "redirect:/questions";
			}

		}

//		    delete request
		@RequestMapping(value = "/questions/{id}/destroy", method = RequestMethod.DELETE)
		public String destroy(@PathVariable("id") Long id) {
			questionService.deleteQuestion(id);
			return "redirect:/questions";
		}
	}

	


