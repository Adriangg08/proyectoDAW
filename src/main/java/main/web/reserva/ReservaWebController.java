package main.web.reserva;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.aplicacion.plato.Plato;
import main.aplicacion.plato.PlatoRepo;
import main.web.carta.Carta;
import main.web.carta.CartaController;
import main.web.carta.CartaRepo;

@RequestMapping("/reservas")
@Controller
public class ReservaWebController {

	@Autowired
	private ReservaRepo reservaRepo;
	
	@Autowired
	private CartaRepo cartaRepo;
	
	@Autowired
	private PlatoRepo platoRepo;
	
	@GetMapping(value = {"","/"})
	String homeReservasWeb(Model model) {
		
		ArrayList<Carta> listaCartas = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("reservaNueva",new Reserva());
		model.addAttribute("platosReserva",CartaController.platosReserva);
		model.addAttribute("listaCartas",listaCartas);
		
		return "reservasWeb";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addReservaWeb(@ModelAttribute("reservaNueva") Reserva reservaNueva, BindingResult bindingResult) {

		reservaRepo.save(reservaNueva);
		
		return "redirect:/reservas";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePlatoReserva(@PathVariable Integer id, Model model) {

		Plato p = platoRepo.findById(id).get();
		
		CartaController.platosReserva.remove(p);
		
		return "redirect:/reservas";
	}
}
