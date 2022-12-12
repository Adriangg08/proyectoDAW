package main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long plato_id;
	
	private String nombre;
	private String alergenos;
	private String descripcion;
	private boolean disponible;
	private Double precio;
}
