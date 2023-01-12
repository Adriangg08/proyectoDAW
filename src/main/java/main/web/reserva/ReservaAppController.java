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

import main.web.carta.Carta;
import main.web.carta.CartaController;
import main.web.carta.CartaRepo;
import main.web.reserva.Reserva;
import main.web.reserva.ReservaRepo;
import main.web.reserva_plato.Reserva_Platos_Repo;
import main.web.reserva_plato.Reservas_Platos;

@RequestMapping("/aplicacion/reservas")
@Controller
public class ReservaAppController {

	@Autowired
	private ReservaRepo reservaRepo;
	
	@Autowired
	private Reserva_Platos_Repo reserva_Platos_Repo;
	
	@Autowired
	private CartaRepo  cartaRepo;
	
	@GetMapping(value = {"","/"})
	String homereservas(Model model) {
		ArrayList<Reserva> listaReservas = (ArrayList<Reserva>) reservaRepo.findAll();
		ArrayList<Carta> listaCarta = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("listaReservas",listaReservas);
		model.addAttribute("reserva_plato_new", new Reservas_Platos());
		model.addAttribute("reserva_plato_edit", new Reservas_Platos());
		model.addAttribute("reservaEdit",new Reserva());
		model.addAttribute("listaCarta",listaCarta);
		
		return "reservasApp";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addReserva(@ModelAttribute("peserva_plato_new") Reservas_Platos r, BindingResult bindingResult) {

		reserva_Platos_Repo.save(r);
		
		return "redirect:/aplicacion/reservas";
	}
	
	/*Editar por Id*/
	@PostMapping("/edit/{id}")
	public String editarReserva(@PathVariable Integer id, @ModelAttribute("reserva_plato_edit") Reservas_Platos r, BindingResult bindingResult) {
		
		/*Busco la reserva a editar en la BBDD*/
		Reservas_Platos reservaEdited = new Reservas_Platos();
		
		/*Edito cada atributo*/
		reservaEdited.getReserva().setNombre( r.getReserva().getNombre());
		reservaEdited.getReserva().setTelefono( r.getReserva().getTelefono());
		reservaEdited.getReserva().setMail( r.getReserva().getMail());
		reservaEdited.getReserva().setNum_personas( r.getReserva().getNum_personas());
		reservaEdited.getReserva().setNum_celiacos( r.getReserva().getNum_celiacos());
		reservaEdited.getReserva().setEstado( r.getReserva().getEstado());
		reservaEdited.getReserva().setComentario( r.getReserva().getComentario());
		reservaEdited.getReserva().setPara_llevar( r.getReserva().isPara_llevar());
		reservaEdited.getReserva().setFecha_reserva( r.getReserva().getFecha_reserva());
//		reservaEdited.setPlatos(reservaEdit.getPlatos());
		/*Persist*/
		reserva_Platos_Repo.save(reservaEdited);
		
		return "redirect:/aplicacion/reservas";
	}
	
	/*Borrar por id*/
	@GetMapping("/delete/{id}")
	public String deleteReserva(@PathVariable Integer id, Model model) {
		
		/*Busca la reserva a borrar y sus referencias*/
//		Reserva cartaBorrar = cartaRepo.findById(id).get();
		Reserva reservaBorrar = reservaRepo.findById(id).get();
//		Falta el menu
		
		/*Borrado*/
		reservaRepo.delete(reservaBorrar);
//		cartaRepo.delete(cartaBorrar);
		
		return "redirect:/aplicacion/reservas";
}
	

}
