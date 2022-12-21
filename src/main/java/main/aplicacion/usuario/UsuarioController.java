package main.aplicacion.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/registro")
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService uService;
	
	

	@GetMapping(value = {"","/"})
	String homeregistro(Model model) {
		
		model.addAttribute("usuario",new UsuarioDTO());
		
		return "registro";
	}
	
	@PostMapping
	public String registroUsuario(@ModelAttribute("usuario") UsuarioDTO u) {
		
		uService.save(u);
		
		return "redirect:/registro?exito";
	}
}
