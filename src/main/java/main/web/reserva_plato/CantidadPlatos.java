package main.web.reserva_plato;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CantidadPlatos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 734418731479496327L;

	@Column(name="plato_id")
	private int plato_id;
	
	@Column(name="reserva_id")
	private int reserva_id;

	public int getPlato_id() {
		return plato_id;
	}

	public void setPlato_id(int plato_id) {
		this.plato_id = plato_id;
	}

	public int getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}

	public CantidadPlatos(int plato_id, int reserva_id) {
		this.plato_id = plato_id;
		this.reserva_id = reserva_id;
	}
	
	public boolean equals (CantidadPlatos c) {
		
		//return (this.getPlato_id() == c.getPlato_id() && this.getReserva_id() == c.getReserva_id());
		return (this == c);
		
	}
	
	public int hashCode() {
		
		return Objects.hash(plato_id, reserva_id);
	}
	
	
}
