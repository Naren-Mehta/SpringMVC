package com.naren.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showform")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
	
	
	@RequestMapping("/processformVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		String str= request.getParameter("studentName");
		str=str.toUpperCase();
		
		String result="Yo! " + str;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processformVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String student, Model model) {
		
		String str=student;
		str=str.toUpperCase();
		
		String result="Yo! My friend from v3: " + str;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
}
