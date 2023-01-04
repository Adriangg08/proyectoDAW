package main.web.reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservas")
@Controller
public class ReservaWebController {

	@Autowired
	private ReservaRepo reservaRepo;
	
	@GetMapping(value = {"","/"})
	String homeReservasWeb(Model model) {
		
		model.addAttribute("reservaNueva",new Reserva());
		
		return "reservasWeb";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addReservaWeb(@ModelAttribute("reservaNueva") Reserva reservaNueva, BindingResult bindingResult) {

		reservaRepo.save(reservaNueva);
		
		return "redirect:/reservas";
	}
	
}
