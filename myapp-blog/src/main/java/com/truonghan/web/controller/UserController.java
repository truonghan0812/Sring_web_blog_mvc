package com.truonghan.web.controller;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truonghan.backend.domain.User;
import com.truonghan.backend.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//This create a user model for first request get method
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	
	@RequestMapping(value="/users")
	public String users(Model model){
		System.out.println("Getting in user controller");
		model.addAttribute("users",userService.findAll());
		return "users";
	}
	
	@RequestMapping(value="/users/{id}")
	public String userDetail(Model model, @PathVariable int id){
		System.out.println("--------------------Getting in get user detail controller!--------------------------");
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping(value="/register")
	public String ShowRegister(){
		System.out.println("----------------------Getting in Register Controller!-----------------------------");
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user){
		
//		if(rs.hasErrors()){
//			System.out.println("-------Binding has errors---------");
//			return "user-register";
//		}
//		else{
			System.out.println("-------Saving user---------");
			userService.save(user);
			return "redirect:/users.html";
//		}
		
	}
}
