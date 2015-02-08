package com.truonghan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/index")
	public String Index(){
		System.out.println("Get in contrller");
		return "index";
	}
}
