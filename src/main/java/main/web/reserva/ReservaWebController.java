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
import main.aplicacion.plato.PlatoDTO;
import main.aplicacion.plato.PlatoRepo;
import main.web.carta.Carta;
import main.web.carta.CartaController;
import main.web.carta.CartaRepo;
import main.web.reserva_plato.Reserva_Platos_Repo;
import main.web.reserva_plato.Reservas_Platos;

@RequestMapping("/reservas")
@Controller
public class ReservaWebController {

	@Autowired
	private ReservaRepo reservaRepo;
	
	@Autowired
	private CartaRepo cartaRepo;
	
	@Autowired
	private PlatoRepo platoRepo;
	
	@Autowired
	private Reserva_Platos_Repo reserva_Platos_Repo;
	
	
	@GetMapping(value = {"","/"})
	String homeReservasWeb(Model model) {
		
		ArrayList<Carta> listaCartas = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("reservaNueva",new ReservaDTO());
		model.addAttribute("platosReserva",CartaController.platosReserva);
		model.addAttribute("listaCartas",listaCartas);
		
		return "reservasWeb";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addReservaWeb(@ModelAttribute("reservaNueva") ReservaDTO reservaDTO, BindingResult bindingResult) {
		
		Reservas_Platos rp = null;
		Reserva reservaNueva = new Reserva();
		Plato platoNuevo = new Plato();
		
		reservaRepo.save(reservaNueva.persist(reservaDTO));
		
		for(PlatoDTO p: CartaController.platosReserva) {
			
			rp = new Reservas_Platos();
			rp.setPlato(platoNuevo.persistPlato(p));
			rp.setCantidad(p.getCantidad());
			rp.setReserva(reservaNueva);
			reserva_Platos_Repo.save(rp);
			
		}

		CartaController.platosReserva = new ArrayList<PlatoDTO>();
		
		return "redirect:/reservas";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePlatoReserva(@PathVariable Integer id, Model model) {

		Plato p = platoRepo.findById(id).get();
		PlatoDTO pDTO = new PlatoDTO();
		
		pDTO = p.persistPlatoDTO(pDTO);
		
		if(CartaController.platosReserva.contains(pDTO)) { 
		
			CartaController.platosReserva.remove(pDTO);
			
		} 
			
		
		return "redirect:/reservas";
	}
}
