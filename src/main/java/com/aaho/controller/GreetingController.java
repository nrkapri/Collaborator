package com.aaho.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaho.models.Person;
import com.aaho.repos.NameRepository;



@Controller
public class GreetingController {

	//inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@Autowired
	public NameRepository nameRepository;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		nameRepository.save(new Person(name));
		model.addAttribute("people", nameRepository.findAll());
		return "greeting"; // name of the template file
	}

}
