package com.ashley.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashley.authentication.models.User;
import com.ashley.authentication.services.UserService;

@Controller
public class userController {
	@Autowired
	private UserService userService;

	
//	registration form render
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

//	login form render
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
//	login post request
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email")String email , @RequestParam("password"))
	boolean isAuthenticated = userService.authenticateUser(email, password);

	
//	registration post method to accept the form info and redirect if errors to reg page, if no errors redirects to home page
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		// if result has errors, return the registration page (don't worry about
		// validations just now)
		if (result.hasErrors()) {
			return "/registration";
		} else {
			User u = userService.registerUser(user);
			session.setAttribute("user_id", u.getId());

			return "redirect:/home";
		}

		// else, save the user in the database, save the user id in session, and
		// redirect them to the /home route
	}

//	renders homepage and finds user by id and saves to session
	@RequestMapping(value = "/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("user", u);
		return "homePage.jsp";
	}

	
//	logs out a user
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect: login";
	}
}