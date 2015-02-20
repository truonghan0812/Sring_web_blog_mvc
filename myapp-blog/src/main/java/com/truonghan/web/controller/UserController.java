package com.truonghan.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	@ModelAttribute("blog")
	public Blog getBlog() {
		return new Blog();
	}

	

	

	@RequestMapping(value = "/account")
	public String account(Model model, Principal principal) {
		String userName = principal.getName();
		Integer userId = userService.findByName(userName).getId();
		model.addAttribute("user", userService.findOneWithBlogs(userId));
		return "user-account";
	}
	
	@RequestMapping(value = "/account", method=RequestMethod.POST)
	public String saveBlog(Model model ,@Valid @ModelAttribute("blog") Blog blog, BindingResult rs, Principal principal) {
		
		if(rs.hasErrors()){
		return account(model, principal);
			//return "user-detail";
		}
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
	
	
	
	
	
	
	
	
}
