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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "platos")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "plato", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Carta cartaplato;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alergenos")
	private String alergenos;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "disponible")
	private boolean disponible;
	
	@Column(name = "precio")
	private Double precio;
	
	@ManyToMany(mappedBy = "platos",cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<Reserva> reservas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carta getCartaPlato() {
		return cartaplato;
	}

	public void setCartaPlato(Carta carta) {
		this.cartaplato = carta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}
