package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Carta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long carta_id;
	private String nombre;
	private String alergenos;
	private String descripcion;
	private Double precio;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "carta_id", referencedColumnName = "id_plato")
	private Plato plato;

}
