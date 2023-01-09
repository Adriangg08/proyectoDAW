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

@RequestMapping("/aplicacion/reservas")
@Controller
public class ReservaAppController {

	@Autowired
	private ReservaRepo reservaRepo;
	
	@Autowired
	private CartaRepo  cartaRepo;
	
	@GetMapping(value = {"","/"})
	String homereservas(Model model) {
		ArrayList<Reserva> listaReservas = (ArrayList<Reserva>) reservaRepo.findAll();
		ArrayList<Carta> listaCarta = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("listaReservas",listaReservas);
		model.addAttribute("reservaNueva",new Reserva());
		model.addAttribute("reservaEdit",new Reserva());
		model.addAttribute("listaCarta",listaCarta);
		
		return "reservasApp";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addReserva(@ModelAttribute("reservaNueva") Reserva reservaNueva, BindingResult bindingResult) {

		reservaRepo.save(reservaNueva);
		
		return "redirect:/aplicacion/reservas";
	}
	
	/*Editar por Id*/
	@PostMapping("/edit/{id}")
	public String editarReserva(@PathVariable Integer id, @ModelAttribute("reservaEdit") Reserva reservaEdit, BindingResult bindingResult) {
		
		/*Busco la reserva a editar en la BBDD*/
		Reserva reservaEdited = reservaRepo.findById(id).get();
		
		/*Edito cada atributo*/
		reservaEdited.setNombre(reservaEdit.getNombre());
		reservaEdited.setTelefono(reservaEdit.getTelefono());
		reservaEdited.setMail(reservaEdit.getMail());
		reservaEdited.setNum_personas(reservaEdit.getNum_personas());
		reservaEdited.setNum_celiacos(reservaEdit.getNum_celiacos());
		reservaEdited.setEstado(reservaEdit.getEstado());
		reservaEdited.setComentario(reservaEdit.getComentario());
		reservaEdited.setPara_llevar(reservaEdit.isPara_llevar());
		reservaEdited.setFecha_reserva(reservaEdit.getFecha_reserva());
		reservaEdited.setPlatos(reservaEdit.getPlatos());
		/*Persist*/
		reservaRepo.save(reservaEdited);
		
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
