package main.web.reserva_plato;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import main.aplicacion.plato.Plato;
import main.web.reserva.Reserva;

@Entity
@Table(name="reservas_platos")
public class Reservas_Platos {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 int id;

	 @ManyToOne
	 @JoinColumn(name = "platos_id")
	 Plato plato;

	 @ManyToOne
	 @JoinColumn(name = "reservas_id")
	 Reserva reserva;

	 @Column(name="cantidad")
	 int cantidad;

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Reservas_Platos() {
		
	}

	public Reservas_Platos(Plato plato, Reserva reserva, int cantidad) {
		this.plato = plato;
		this.reserva = reserva;
		this.cantidad = cantidad;
	}
	
	public void crearId() {

		this.id = Integer.parseInt(this.getReserva().getId() + "000" + this.getPlato().getId());
		
	}
	 
	 
}
