package com.app.crm.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("theDate", new java.util.Date());
	
		return "abc";
	}
	
}
