package com.truonghan.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truonghan.backend.domain.Blog;
import com.truonghan.backend.domain.User;
import com.truonghan.backend.services.BlogService;
import com.truonghan.backend.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;

	// This create a user model for first request get method in views
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	// This create a user model for first request get method in views
	@ModelAttribute("blog")
	public Blog getBlog() {
		return new Blog();
	}

	@RequestMapping(value = "/users")
	public String users(Model model) {
		System.out.println("Getting in user controller");
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping(value = "/users/{id}")
	public String userDetail(Model model, @PathVariable int id) {
		System.out
				.println("--------------------Getting in get user detail controller!--------------------------");
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping(value = "/register")
	public String ShowRegister() {
		System.out
				.println("----------------------Getting in Register Controller!-----------------------------");
		return "user-register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		System.out.println("-------Saving user---------");
		userService.save(user);
		return "redirect:/register.html?success=true";

	}

	@RequestMapping(value = "/account")
	public String account(Model model, Principal principal) {
		String userName = principal.getName();
		Integer userId = userService.findByName(userName).getId();
		model.addAttribute("user", userService.findOneWithBlogs(userId));
		return "user-detail";
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
		System.out.println("-------Saving blog---------");
		
		String userName = principal.getName();
		blogService.saveByUser(blog, userName);
		
		return "redirect:/account.html";

	}
	@RequestMapping(value="/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
	@RequestMapping(value="/users/remove/{id}")
	public String removeUser(@PathVariable int id){
		User user =userService.findOne(id);
		userService.delete(user);
		return "redirect:/users.html";
	}
	
	
	
	
	
	
	
}
