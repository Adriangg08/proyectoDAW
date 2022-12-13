package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "gluten")
	private boolean gluten;
	
	@Column(name = "lactosa")
	private boolean lactosa;

	@OneToOne
	private Stock stock;
	
//	@ManyToOne
//	@JoinColumn(name="id_almacen", nullable = false)
//	@JsonIgnore
//	private Almacen almacen;
}
