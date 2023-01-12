package main.web.carta;

import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.aplicacion.plato.Plato;
import main.aplicacion.plato.PlatoDTO;
import main.aplicacion.plato.PlatoRepo;
import main.web.reserva.Reserva;


@RequestMapping("/carta")
@Controller
public class CartaController {

	@Autowired
	private CartaRepo cartaRepo;
	
	@Autowired
	private PlatoRepo platoRepo;
	
	/*
	 * Variable global para controlador reserva
	 * Permite llevar platos a pagina reserva
	 * */
	public static ArrayList<PlatoDTO> platosReserva = new ArrayList<PlatoDTO>();
	
	@GetMapping(value = {"","/"})
	String homecartas(Model model) {
		
		ArrayList<Plato> listaPlatos = (ArrayList<Plato>) platoRepo.findAll();
		
		for (Plato p: listaPlatos) {

			if(p.isDisponible()) {
				cartaRepo.save(p.persistC());
			}
			
		}
  		
		ArrayList<Carta> listaCartas = (ArrayList<Carta>) cartaRepo.findAll();
		ArrayList<String> listaCategorias = new ArrayList<String>();
		listaCategorias.add("ENTRANTES");
		listaCategorias.add("PRIMEROS");
		listaCategorias.add("SEGUNDOS");
		listaCategorias.add("POSTRES");
		listaCategorias.add("BEBIDAS");
		
		model.addAttribute("listaCartas",listaCartas);
		model.addAttribute("listaCategorias",listaCategorias);
		model.addAttribute("platoPedido",new Plato());
		model.addAttribute("platosReserva",platosReserva);
		
		/*CAMBIAR ESTO*/
		model.addAttribute("listaPlatos",listaPlatos);
		
		/*
		model.addAttribute("cartaNueva",new Carta());
		model.addAttribute("platoEdit",new Plato());
		*/
		
		return "cartaBien";
	}
	
	@GetMapping("/add/{id}")
	public String addPlatoReserva(@PathVariable Integer id, Model model) {

		Plato p = platoRepo.findById(id).get();
		PlatoDTO pDTO = new PlatoDTO();
		
		pDTO = p.persistPlatoDTO(pDTO);
		
		if (platosReserva.isEmpty()) {
			
			platosReserva.add(pDTO);
			
		} else {
		
			ListIterator<PlatoDTO> platos = platosReserva.listIterator();
			platosReserva.clear();
			
			while(platos.hasNext()) {
				
				PlatoDTO plato = platos.next();
				
				if(plato.getId() == pDTO.getId()) { 
					
					platos.remove();
					plato.setCantidad(pDTO.getCantidad()+1);
					platos.add(plato);
					
				} 
				
				platosReserva.add(plato);
				
			}
		
		}
		
		return "redirect:/carta";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePlatoReserva(@PathVariable Integer id, Model model) {

		Plato p = platoRepo.findById(id).get();
		PlatoDTO pDTO = new PlatoDTO();
		
		pDTO = p.persistPlatoDTO(pDTO);
		
		if(platosReserva.contains(pDTO)) { 
		
			platosReserva.remove(pDTO);
			
		} 

		return "redirect:/carta";
	}

	
	/*Añadir
	@PostMapping("/add/")
	public String addCarta(@ModelAttribute("cartaNueva") Carta cartaNueva, BindingResult bindingResult) {

		Plato p = platoRepo.findById(cartaNueva.getId()).get();
		p.setDisponible(true);
		platoRepo.save(p);
		
		return "redirect:/carta";
	}
	
	/*Editar por Id
	@PostMapping("/edit/{id}")
	public String editarCarta(@PathVariable Integer id,@ModelAttribute("platoEdit") Plato platoEdit, BindingResult bindingResult) {
		
		/*Busco la carta a editar en la BBDD
		Plato platoEdited = platoRepo.findById(id).get();
		
		/*Edito cada atributo
		platoEdited.setNombre(platoEdit.getNombre());
		platoEdited.setDescripcion(platoEdit.getDescripcion());
		platoEdited.setAlergenos(platoEdit.getAlergenos());
		platoEdited.setPrecio(platoEdit.getPrecio());
//		platoEdited.setPlato(platoEdit.getPlato());
//		platoEdited.setMenu(platoEdited.getMenu());
		
		/*Persist
		platoRepo.save(platoEdited);
		
		return "redirect:/carta";
	}
	
	/*Borrar por id
	@GetMapping("/delete/{id}")
	public String deleteCarta(@PathVariable Integer id, Model model) {
		
		/*Busca la carta a borrar y sus referencias
//		Carta cartaBorrar = cartaRepo.findById(id).get();
//		Plato platoBorrar = platoRepo.findById(id).get();
//		Falta el menu
		
		/*Borrado
//		cartaRepo.delete(cartaBorrar);
//		platoRepo.delete(platoBorrar);
		
		Plato p = platoRepo.findById(id).get();
		p.setDisponible(false);
		platoRepo.save(p);
		
		return "redirect:/carta";
	}
	*/
}
