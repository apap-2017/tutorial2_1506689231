package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	/*@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required = false,
	defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}*/
	
	/*@RequestMapping ( "/greeting/{name}")
	public String greetingPath(@PathVariable String name ,Model model){
		model.addAttribute("name", name);
		return "greeting";
	}*/
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional <String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian (
			@RequestParam(value = "a", required = false, defaultValue = "0") int a, Model model1,
			@RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model2,
			@RequestParam(value = "hasil", required = false, defaultValue = "0") int hasil, Model model3){
		
		model1.addAttribute("a", a);
		model2.addAttribute("b", b);
		
		hasil = a * b;
		
		model3.addAttribute("hasil", hasil);
		
		return "perkalian";
	}
}
