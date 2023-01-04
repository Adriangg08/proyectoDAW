package main.aplicacion.plato;

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

import main.web.carta.CartaRepo;



@RequestMapping("/aplicacion/platos")
@Controller
public class PlatoController {
		
		@Autowired
		private PlatoRepo platoRepo;
		
		@GetMapping(value = {"","/"})
		String homeplatos(Model model) {
			ArrayList<Plato> listaPlatos = (ArrayList<Plato>) platoRepo.findAll();
			
			model.addAttribute("listaPlatos",listaPlatos);
			model.addAttribute("platoNuevo",new Plato());
			model.addAttribute("platoEdit",new Plato());
			
			return "indexapp";
		}
		
		/*Añadir*/
		@PostMapping("/add/")
		public String addPlato(@ModelAttribute("platoNuevo") Plato platoNuevo, BindingResult bindingResult) {

			platoRepo.save(platoNuevo);
			
			return "redirect:/aplicacion/platos";
		}
		
		/*Editar por Id*/
		@PostMapping("/edit/{id}")
		public String editarPlato(@PathVariable Integer id, @ModelAttribute("platoEdit") Plato platoEdit, BindingResult bindingResult) {
			
			/*Busco la plato a editar en la BBDD*/
			Plato platoEdited = platoRepo.findById(id).get();
			
			/*Edito cada atributo*/
			platoEdited.setNombre(platoEdit.getNombre());
			platoEdited.setDescripcion(platoEdit.getDescripcion());
			platoEdited.setAlergenos(platoEdit.getAlergenos());
			platoEdited.setPrecio(platoEdit.getPrecio());
			platoEdited.setDisponible(platoEdit.isDisponible());
//			platoEdited.setMenu(platoEdited.getMenu());
			
			/*Persist*/
			platoRepo.save(platoEdited);
			
			return "redirect:/aplicacion/platos";
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
			
			return "redirect:/aplicacion/platos";
	}


}
