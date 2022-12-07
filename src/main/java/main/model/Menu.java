package main.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

public class Menu {
	
	//De los platos disponibles (Carta) unos pocos (menu)
	
	@Id
	@Column(name = "id_menu_plato")
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id_menu_plato", referencedColumnName = "id_carta_plato")
	private Carta carta_menu;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alergenos")
	private String alergenos;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carta getCarta_menu() {
		return carta_menu;
	}

	public void setCarta_menu(Carta carta_menu) {
		this.carta_menu = carta_menu;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}