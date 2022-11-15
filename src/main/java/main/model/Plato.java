package main.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "platos")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alergenos")
	private String alergenos;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "isDisponible")
	private boolean isDisponible;
	
	@Column(name = "precio")
	private Double precio;
	
	@ManyToMany(mappedBy = "platos",cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<Reserva> reservas;
}
