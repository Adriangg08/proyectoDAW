package main.controller;

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

import main.daos.CartaRepo;
import main.daos.PlatoRepo;
import main.model.Carta;
import main.model.Plato;


@RequestMapping("/carta")
@Controller
public class CartaController {

	@Autowired
	private CartaRepo cartaRepo;
	
	@Autowired
	private PlatoRepo platoRepo;
	
	@GetMapping(value = {"","/"})
	String homecartas(Model model) {
		ArrayList<Carta> listaCartas = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("listaCartas",listaCartas);
		model.addAttribute("cartaNueva",new Carta());
		model.addAttribute("cartaEdit",new Carta());
		
		return "cartas";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addCarta(@ModelAttribute("cartaNueva") Carta cartaNueva, BindingResult bindingResult) {

		cartaRepo.save(cartaNueva);
		
		return "redirect:/carta";
	}
	
	/*Editar por Id*/
	@PostMapping("/edit/{id}")
	public String editarCarta(@PathVariable Integer id,@ModelAttribute("cartaEdit") Carta cartaEdit, BindingResult bindingResult) {
		
		/*Busco la carta a editar en la BBDD*/
		Carta cartaEdited = cartaRepo.findById(id).get();
		
		/*Edito cada atributo*/
		cartaEdited.setNombre(cartaEdit.getNombre());
		cartaEdited.setDescripcion(cartaEdit.getDescripcion());
		cartaEdited.setAlergenos(cartaEdit.getAlergenos());
		cartaEdited.setPrecio(cartaEdit.getPrecio());
//		cartaEdited.setPlato(cartaEdit.getPlato());
//		cartaEdited.setMenu(cartaEdited.getMenu());
		
		/*Persist*/
		cartaRepo.save(cartaEdited);
		
		return "redirect:/carta";
	}
	
	/*Borrar por id*/
	@GetMapping("/delete/{id}")
	public String deleteCarta(@PathVariable Integer id, Model model) {
		
		/*Busca la carta a borrar y sus referencias*/
		Carta cartaBorrar = cartaRepo.findById(id).get();
//		Plato platoBorrar = platoRepo.findById(id).get();
//		Falta el menu
		
		/*Borrado*/
		cartaRepo.delete(cartaBorrar);
//		platoRepo.delete(platoBorrar);
		
		return "redirect:/carta";
	}
}
