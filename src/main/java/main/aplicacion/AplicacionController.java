package main.aplicacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/aplicacion")
@Controller
public class AplicacionController {
	
	@GetMapping(value = {"","/"})
	String home() {
		return "indexApp";
	}
	
}