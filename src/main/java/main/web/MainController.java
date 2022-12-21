package main.web;

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
	
	@GetMapping("/fartucate")
	String homeFartucate() {
		return "fartucate";
	}
	
	@GetMapping("/contacto")
	String homeContacto() {
		return "contacto";
	}
	
	@GetMapping("/premios")
	String homePremios() {
		return "premios";
	}
	
	/*
	@GetMapping("/ingrediente")
	String homeIngrediente() {
		return "index";
	}
	*/
}
