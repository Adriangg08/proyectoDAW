package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.aplicacion.roles.Rol;
import main.aplicacion.usuario.Usuario;
import main.daos.GenericDAO;
import main.web.carta.Carta;
import main.web.plato.Plato;

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
		
//		GenericDAO<Usuario> uDAO = new GenericDAO<>(Usuario.class);
//		
//		Usuario u1 = new Usuario();
//		
//		GenericDAO<Rol> rDAO = new GenericDAO<>(Rol.class);
//		
//		Rol r1 = new Rol();
//		
//		u1.setNombre("adrian");
//		u1.setPassword("1234");
//		
//		r1.setNombre("admin");
//		
//		r1.getUsuarios().add(u1);
//		u1.getRoles().add(r1);
//		
//		uDAO.insertarTJPA(u1);
//		rDAO.insertarTJPA(r1);
		
//		GenericDAO<Plato> pDao = new GenericDAO<Plato>(Plato.class);
//		
//		Plato p1 = new Plato();
//		p1.setNombre("Tarta chocolate");
//		p1.setAlergenos("Lactosa");
//		p1.setDescripcion("Tarta de chocolate espectacular");
//		p1.setDisponible(true);
//		p1.setPrecio(20.0);
//		p1.setUrl("Tarta Chocolate.jpeg");
//		
//		Plato p2 = new Plato();
//		p2.setNombre("Filete solomillo");
//		p2.setDisponible(true);
//		p2.setDescripcion("Filete de solomillo en milhoja de manchego");
//		p2.setPrecio(25.0);
//		p2.setUrl("Filete de solomillo en milhoja de manchego.jpeg");
//		
//		
//		Plato p3 = new Plato();
//		p3.setNombre("Pote Asturiano");
//		p3.setDisponible(true);
//		p3.setDescripcion("Pote Asturiano con fabes de nose donde muy buenes");
//		p3.setPrecio(30.0);
//		p3.setUrl("Pote Asturiano.jpeg");
		
//		Plato p4 = new Plato();
//		p4.setNombre("cachopo");
//		p4.setDisponible(true);
//		p4.setDescripcion("Filete de solomillo en milhoja de manchego");
//		p4.setPrecio(30.0);
//		
//		Plato p5 = new Plato();
//		p5.setNombre("cachopo");
//		p5.setDisponible(true);
//		p5.setDescripcion("Filete de solomillo en milhoja de manchego");
//		p5.setPrecio(30.0);
//		
//		Plato p6 = new Plato();
//		p6.setNombre("cachopo");
//		p6.setDisponible(true);
//		p6.setDescripcion("Filete de solomillo en milhoja de manchego");
//		p6.setPrecio(30.0);
//		
//		Plato p7 = new Plato();
//		p7.setNombre("cachopo");
//		p7.setDisponible(true);
//		p7.setDescripcion("Filete de solomillo en milhoja de manchego");
//		p7.setPrecio(30.0);
		
//		pDao.insertarTJPA(p1);
//		pDao.insertarTJPA(p2);
//		pDao.insertarTJPA(p3);
//		pDao.insertarTJPA(p4);
//		pDao.insertarTJPA(p5);
//		pDao.insertarTJPA(p6);
//		pDao.insertarTJPA(p7);
		
		SpringApplication.run(Main.class, args);

	}

}
