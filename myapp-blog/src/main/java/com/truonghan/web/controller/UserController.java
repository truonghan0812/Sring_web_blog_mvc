package com.truonghan.web.controller;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.truonghan.backend.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
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
	
	
}
