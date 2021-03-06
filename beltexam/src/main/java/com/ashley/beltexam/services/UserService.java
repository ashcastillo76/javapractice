package com.ashley.beltexam.services;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ashley.beltexam.models.LoginUser;
import com.ashley.beltexam.models.User;
import com.ashley.beltexam.repositories.UserRepo;


@Service
public class UserService {

	    @Autowired
	    private UserRepo userRepo;
	    
	    public User register(User newUser, BindingResult result) {
//	        checking uniqueness
	    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
	            result.rejectValue("email", "Unique", "This email is already in use!");
	        }
//	        do passwords match?
	        if(!newUser.getPassword().equals(newUser.getConfirm())) {
	            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	        }
//	        errors? return null
	        if(result.hasErrors()) {
	            return null;
	        } else {
//	        	otherwise hash password and add salt, set the password to the hashed password and save newUser
	            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	            newUser.setPassword(hashed);
	            return userRepo.save(newUser);
	        }
	    }
	    
	    public User login(LoginUser newLogin, BindingResult result, HttpSession session) {
	        if(result.hasErrors()) {
	            return null;
	        }
	        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	        if(!potentialUser.isPresent()) {
	            result.rejectValue("email", "Unique", "Unknown email!");
	            return null;
	        }
	        User user = potentialUser.get();
	        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	        	session.setAttribute("user", user);
	            return user;
	        }
	    }
	    
	    public User findUserById(Long id) {
	    	Optional<User> u = userRepo.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }
	    
	}

	
	
	

