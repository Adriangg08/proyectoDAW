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

import main.daos.PlatoRepo;
import main.model.Plato;



@RequestMapping("/plato")
@Controller
public class PlatoController {

		@Autowired
		private PlatoRepo cartaRepo;
		
		@Autowired
		private PlatoRepo platoRepo;
		
		@GetMapping(value = {"","/"})
		String homeplatos(Model model) {
			ArrayList<Plato> listaPlatos = (ArrayList<Plato>) platoRepo.findAll();
			
			model.addAttribute("listaPlatos",listaPlatos);
			model.addAttribute("platoNueva",new Plato());
			model.addAttribute("platoEdit",new Plato());
			
			return "platos";
		}
		
		/*Añadir*/
		@PostMapping("/add/")
		public String addPlato(@ModelAttribute("platoNueva") Plato platoNueva, BindingResult bindingResult) {

			platoRepo.save(platoNueva);
			
			return "redirect:/plato";
		}
		
		/*Editar por Id*/
		@PostMapping("/edit/{id}")
		public String editarPlato(@PathVariable Integer id,@ModelAttribute("platoEdit") Plato platoEdit, BindingResult bindingResult) {
			
			/*Busco la plato a editar en la BBDD*/
			Plato platoEdited = platoRepo.findById(id).get();
			
			/*Edito cada atributo*/
			platoEdited.setNombre(platoEdit.getNombre());
			platoEdited.setDescripcion(platoEdit.getDescripcion());
			platoEdited.setAlergenos(platoEdit.getAlergenos());
			platoEdited.setPrecio(platoEdit.getPrecio());
//			platoEdited.setPlato(platoEdit.getPlato());
//			platoEdited.setMenu(platoEdited.getMenu());
			
			/*Persist*/
			platoRepo.save(platoEdited);
			
			return "redirect:/plato";
		}
		
		/*Borrar por id*/
		@GetMapping("/delete/{id}")
		public String deletePlato(@PathVariable Integer id, Model model) {
			
			/*Busca la plato a borrar y sus referencias*/
//			Plato cartaBorrar = cartaRepo.findById(id).get();
			Plato platoBorrar = platoRepo.findById(id).get();
//			Falta el menu
			
			/*Borrado*/
			platoRepo.delete(platoBorrar);
//			cartaRepo.delete(cartaBorrar);
			
			return "redirect:/plato";
	}


}
