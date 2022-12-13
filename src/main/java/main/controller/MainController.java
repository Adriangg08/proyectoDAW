package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
@Controller
public class MainController {
	
	@GetMapping(value = {"","/"})
	String home() {
		
		
		return "index";
	}
	
}