package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.daos.CartaRepo;
import main.daos.IngredienteRepo;
import main.daos.MenuRepo;
import main.daos.PlatoRepo;
import main.daos.ReservaRepo;
import main.daos.StockRepo;
import main.model.Carta;
import main.model.Ingrediente;
import main.model.Menu;
import main.model.Plato;
import main.model.Reserva;
import main.model.Stock;


@RequestMapping("/")
@Controller
public class MainController {

	
	@Autowired
	private static CartaRepo cartaRepo;
	
	@Autowired
	private static IngredienteRepo ingredienteRepo;
	
	@Autowired
	private static MenuRepo menuRepo;
	
	@Autowired
	private static PlatoRepo platoRepo;
	
	@Autowired
	private static ReservaRepo reservaRepo;
	
	@Autowired
	private static StockRepo stockRepo;
	
	@GetMapping(value = {"","/"})
	String home() {
		
		
		Carta carta = new Carta();
		Ingrediente ingrediente = new Ingrediente();
		Menu menu = new Menu();
		Plato plato = new Plato();
		Reserva reserva = new Reserva();
		Stock stock = new Stock();
		
		cartaRepo.save(carta);
		ingredienteRepo.save(ingrediente);
		menuRepo.save(menu);
		reservaRepo.save(reserva);
		stockRepo.save(stock);
		platoRepo.save(plato);
		
		
		
		
		return "/";
	}
	
}
