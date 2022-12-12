package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cartas")
public class Carta2 {

	//Platos disponibles
	
	//La id es la del plato
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id_plato")
	private Plato2 plato;
	
	@OneToOne(mappedBy = "cartamenu", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Menu2 menu;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "alergenos")
	private String alergenos;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;

	public Carta2() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plato2 getPlato() {
		return plato;
	}

	public void setPlato(Plato2 plato) {
		this.plato = plato;
	}

	public Menu2 getMenu() {
		return menu;
	}

	public void setMenu(Menu2 menu) {
		this.menu = menu;
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
