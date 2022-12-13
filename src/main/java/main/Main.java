package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.daos.GenericDAO;
import main.model.Carta;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

//		GenericDAO<Carta> cDao = new GenericDAO<Carta>(Carta.class);
//		
//		Carta c1 = new Carta();
//		c1.setNombre("cachopo");
//		c1.setAlergenos("Lactosa oeuao aoeuoa");
//		c1.setPrecio(30.0);
//		
//		cDao.insertarTJPA(c1);
		
		SpringApplication.run(Main.class, args);

	}

}
