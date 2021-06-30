package com.ashley.beltexam.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashley.beltexam.models.LoginUser;
import com.ashley.beltexam.models.User;
import com.ashley.beltexam.services.UserService;


@Controller
public class UserController {
		@Autowired
		private UserService userService;

//		reroute
	    
	    @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
		
//		registration form render
		@GetMapping("/registration")
		public String registerForm(@ModelAttribute("user") User user) {
			return "index.jsp";
		}

//		login form render
		@GetMapping("/login")
		public String login() {
			return "index.jsp";
		}
		
//		login post request
		 @PostMapping("/login")
		    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
		            BindingResult result, Model model, HttpSession session) {
		        User user = userService.login(newLogin, result);
		        if(result.hasErrors()) {
		            model.addAttribute("newUser", new User());
		            return "index.jsp";
		        }
		        session.setAttribute("user_id", user.getId());
		        return "redirect:/home";
		    }
		    
		
		
//		registration post method to accept the form info and redirect if errors to reg page, if no errors redirects to home page
		@PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userService.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	    

//		renders homepage and finds user by id and saves to session
		@GetMapping(value = "/home")
		public String home(HttpSession session, Model model) {
			Long id = (Long) session.getAttribute("user_id");
			User user = userService.findUserById(id);
			model.addAttribute("user", user);
			return "homePage.jsp";
		}

		
//		logs out a user
		@GetMapping(value = "/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect: login";
		}
		
	}
		    
		    
		
		    
		   

	

