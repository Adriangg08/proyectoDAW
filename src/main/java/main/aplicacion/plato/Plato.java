package main.aplicacion.plato;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import main.web.carta.Carta;
import main.web.reserva.Reserva;
import main.web.reserva_plato.Reservas_Platos;

@Entity
@Table(name = "platos")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
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
	private boolean disponible = false;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name="url")
	private String url;
	
	@Column(name="categoria")
	private String categoria;
	
//	@ManyToMany(mappedBy = "platos",cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
//	private Set<Reserva> reservas;
	
	@OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "reserva")
	private Set<Reservas_Platos> reservas_platos;
	
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
		url = nombre+".jpeg";
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

//	public Set<Reserva> getReservas() {
//		return reservas;
//	}
//
//	public void setReservas(Set<Reserva> reservas) {
//		this.reservas = reservas;
//	}

	public String getUrl() {
		return url;
	}

	public Set<Reservas_Platos> getReservas_platos() {
		return reservas_platos;
	}

	public void setReservas_platos(Set<Reservas_Platos> reservas_platos) {
		this.reservas_platos = reservas_platos;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Carta getCartaplato() {
		return cartaplato;
	}

	public void setCartaplato(Carta cartaplato) {
		this.cartaplato = cartaplato;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Carta persistCarta(Carta c) {
		c.setId(getId());
		c.setDescripcion(getDescripcion());
		c.setNombre(getNombre());
		c.setPrecio(getPrecio());
		c.setAlergenos(getAlergenos());
		c.setUrl(getUrl());
		
		return c;
	}
	
	public Carta persistC() {
		Carta c = new Carta();
		c.setId(getId());
		c.setDescripcion(getDescripcion());
		c.setNombre(getNombre());
		c.setPrecio(getPrecio());
		c.setAlergenos(getAlergenos());
		c.setUrl(getUrl());
		
		return c;
	}
	
	public PlatoDTO persistPlatoDTO(PlatoDTO p) {

		p.setId(getId());
		p.setDescripcion(getDescripcion());
		p.setNombre(getNombre());
		p.setPrecio(getPrecio());
		p.setAlergenos(getAlergenos());
		p.setUrl(getUrl());
		p.setCantidad(1);
		
		return p;
	}

	public Plato persistPlato(PlatoDTO p) {

		this.setId(p.getId());
		this.setDescripcion(p.getDescripcion());
		this.setNombre(p.getNombre());
		this.setPrecio(p.getPrecio());
		this.setAlergenos(p.getAlergenos());
		this.setUrl(p.getUrl());
		
		return this;
	}

	public Plato() {
		reservas_platos = new HashSet<Reservas_Platos>();
	}
	
	
	
}
