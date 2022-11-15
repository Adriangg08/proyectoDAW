package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "hasGluten")
	private boolean hasGluten;
	
	@Column(name = "hasLactosa")
	private boolean hasLactosa;
	
	@Column(name = "cantidadDisponible")
	private int cantidadDisponible;
	
	@Column(name = "cantidadAdecuada")
	private int cantidadAdecuada;
	
}
