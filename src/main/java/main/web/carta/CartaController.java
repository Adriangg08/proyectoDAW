package main.web.carta;

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

import main.web.plato.Plato;
import main.web.plato.PlatoRepo;


@RequestMapping("/carta")
@Controller
public class CartaController {

	@Autowired
	private CartaRepo cartaRepo;
	
	@Autowired
	private PlatoRepo platoRepo;
	
	@GetMapping(value = {"","/"})
	String homecartas(Model model) {
		
		ArrayList<Plato> listaPlatos = (ArrayList<Plato>) platoRepo.findAll();
		
		for (Plato p: listaPlatos) {

			if(p.isDisponible()) {
				cartaRepo.save(p.persist());
			}
			
		}
  		
		ArrayList<Carta> listaCartas = (ArrayList<Carta>) cartaRepo.findAll();
		
		model.addAttribute("listaCartas",listaCartas);
		model.addAttribute("listaPlatos",listaPlatos);
		model.addAttribute("cartaNueva",new Carta());
		model.addAttribute("platoEdit",new Plato());
		
		return "carta";
	}
	
	/*Añadir*/
	@PostMapping("/add/")
	public String addCarta(@ModelAttribute("cartaNueva") Carta cartaNueva, BindingResult bindingResult) {

		Plato p = platoRepo.findById(cartaNueva.getId()).get();
		p.setDisponible(true);
		platoRepo.save(p);
		
		return "redirect:/carta";
	}
	
	/*Editar por Id*/
	@PostMapping("/edit/{id}")
	public String editarCarta(@PathVariable Integer id,@ModelAttribute("platoEdit") Plato platoEdit, BindingResult bindingResult) {
		
		/*Busco la carta a editar en la BBDD*/
		Plato platoEdited = platoRepo.findById(id).get();
		
		/*Edito cada atributo*/
		platoEdited.setNombre(platoEdit.getNombre());
		platoEdited.setDescripcion(platoEdit.getDescripcion());
		platoEdited.setAlergenos(platoEdit.getAlergenos());
		platoEdited.setPrecio(platoEdit.getPrecio());
//		platoEdited.setPlato(platoEdit.getPlato());
//		platoEdited.setMenu(platoEdited.getMenu());
		
		/*Persist*/
		platoRepo.save(platoEdited);
		
		return "redirect:/carta";
	}
	
	/*Borrar por id*/
	@GetMapping("/delete/{id}")
	public String deleteCarta(@PathVariable Integer id, Model model) {
		
		/*Busca la carta a borrar y sus referencias*/
//		Carta cartaBorrar = cartaRepo.findById(id).get();
//		Plato platoBorrar = platoRepo.findById(id).get();
//		Falta el menu
		
		/*Borrado*/
//		cartaRepo.delete(cartaBorrar);
//		platoRepo.delete(platoBorrar);
		
		Plato p = platoRepo.findById(id).get();
		p.setDisponible(false);
		platoRepo.save(p);
		
		return "redirect:/carta";
	}
}
