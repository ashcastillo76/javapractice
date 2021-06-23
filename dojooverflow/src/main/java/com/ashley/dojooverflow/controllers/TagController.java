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

import com.ashley.dojooverflow.models.Tag;
import com.ashley.dojooverflow.services.QuestionService;
import com.ashley.dojooverflow.services.AnswerService;
import com.ashley.dojooverflow.services.TagService;



@Controller
public class TagController {

			@Autowired
			private AnswerService answerService;

			@Autowired
			private QuestionService questionService;
			
			@Autowired
			private TagService tagService;

//				    shows all tags
			@RequestMapping("/tags")
			public String index(Model model) {
				List<Tag> tags = tagService.allTags();
				model.addAttribute("tags", tags);
				return "/tags/showAll.jsp";
			}

//				    form for a new Category
			@RequestMapping("/tags/new")
			public String newCategory(@ModelAttribute("tag") Tag tag, Model model) {
				model.addAttribute("tags", tagService.allTags());
				return "/tags/new.jsp";
			}

//				    post method to create a tag
			@RequestMapping(value = "/tags/new", method = RequestMethod.POST)
			public String create(@Valid @ModelAttribute("tag") Tag tag, BindingResult result) {
				if (result.hasErrors()) {
					return "/tags/new.jsp";
				} else {
					tagService.createTag(tag);
					return "redirect:/tags";
				}
			}

//				show
			@RequestMapping(value = "/tags/{tag_id}")
				public String show(@PathVariable("tag_id") Long tag_id, Model model) {
					model.addAttribute("questions", questionService.allQuestions());
					model.addAttribute("tag", tagService.findTag(tag_id));
					return "/tags/showOne.jsp";
				}

//				    edit Category
			@RequestMapping("/tags/{tag_id}/edit")
			public String edit(@PathVariable("id") Long id, Model model) {
				Tag tag = tagService.findTag(id);
				model.addAttribute("tag", tag);
				return "/tags/edit.jsp";
			}

////				post request to add product to a tag
//			@RequestMapping(value = "/tags/{tag_id}/edit", method = RequestMethod.POST)
//			public String addTagToQuestion(@PathVariable("tag_id") Long tag_id,
//					@RequestParam("question_id") Long question_id) {
	//
//				Tag myTag = tagService.findTag(tag_id);
//				Question myQuestion = questionService.findQuestion(question_id);
	//
//				myTag.getQuestion().add(myQuestion);
//				tagService.updateTagObject(myTag);
	//
//				return "redirect:/tags/" + tag_id;
//			}

			// put request to update edit
			@RequestMapping(value = "/tags/{id}/edit", method = RequestMethod.PUT)
			public String update(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model,
					@PathVariable("id") Long id) {
				if (result.hasErrors()) {
					return "/tags/edit.jsp";
				} else {
					tagService.updateTagObject(tag);
					return "redirect:/tags";
				}

			}

//				    delete request
			@RequestMapping(value = "/tags/{id}/destroy", method = RequestMethod.DELETE)
			public String destroy(@PathVariable("id") Long id) {
				tagService.deleteTag(id);
				return "redirect:/tags";
			}
		}

		
		
		


	
	
