package main.aplicacion.plato;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import main.web.carta.Carta;
import main.web.reserva_plato.Reservas_Platos;

public class PlatoDTO {

	private int id;
	
	private Carta cartaplato;

	private String nombre;

	private String alergenos;

	private String descripcion;

	private boolean disponible = false;

	private Double precio;

	private String url;

	private String categoria;

	private Set<Reservas_Platos> reservas_platos;
	
	private int cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carta getCartaplato() {
		return cartaplato;
	}

	public void setCartaplato(Carta cartaplato) {
		this.cartaplato = cartaplato;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<Reservas_Platos> getReservas_platos() {
		return reservas_platos;
	}

	public void setReservas_platos(Set<Reservas_Platos> reservas_platos) {
		this.reservas_platos = reservas_platos;
	}
	
	public PlatoDTO() {
		reservas_platos = new HashSet<Reservas_Platos>();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
