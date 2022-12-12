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
import main.model.Carta2;
import main.model.Ingrediente2;
import main.model.Menu2;
import main.model.Plato2;
import main.model.Reserva2;
import main.model.Stock2;


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
		
		
		Carta2 carta = new Carta2();
		Ingrediente2 ingrediente = new Ingrediente2();
		Menu2 menu = new Menu2();
		Plato2 plato = new Plato2();
		Reserva2 reserva = new Reserva2();
		Stock2 stock = new Stock2();
		
		cartaRepo.save(carta);
		ingredienteRepo.save(ingrediente);
		menuRepo.save(menu);
		reservaRepo.save(reserva);
		stockRepo.save(stock);
		platoRepo.save(plato);
		
		
		
		
		return "index";
	}
	
}
