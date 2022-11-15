package main.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


enum Estado {
	PENDIENTE,PROCESO,COMPLETADO;
}

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "numPersonas")
	private int numPersonas;
	
	@Column(name = "numCeliacos")
	private int numCeliacos;
	
	@Column(name = "estado")
	private Estado estado;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "esParaLlevar")
	private boolean esParaLlevar;
	
	@Column(name = "fechaReserva")
	private Date fechaReserva;
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "platos_reservas", 
			joinColumns = {@JoinColumn(name = "id_reserva")}, 
			inverseJoinColumns = {@JoinColumn(name = "id_plato")}
		)
	private Set<Plato> platos;
	
}
