package main.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="stock")
public class Stock2 {
	
	@Id
	@Column(name = "id_stock_ingrediente")
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id_stock_ingrediente", referencedColumnName = "id_ingrediente")
	private Ingrediente2 ingrediente;
	
	@Column(name = "cantidad_disponible")
	private int cantidad_disponible;
	
	@Column(name = "cantidad_adecuada")
	private int cantidad_adecuada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingrediente2 getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente2 ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	public int getCantidad_adecuada() {
		return cantidad_adecuada;
	}

	public void setCantidad_adecuada(int cantidad_adecuada) {
		this.cantidad_adecuada = cantidad_adecuada;
	}
	
	
}
