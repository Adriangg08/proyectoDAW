package main.web.reserva;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import main.web.reserva_plato.Reservas_Platos;

public class ReservaDTO {

	private int id;
	
	private String nombre;

	private int telefono;

	private String mail;

	private int num_personas;

	private int num_celiacos;

	private Estado estado;

	private String comentario;

	private boolean para_llevar;

	private Date fecha_reserva;
	
	private Set<Reservas_Platos> reservas_platos;
	
	public ReservaDTO() {
		estado = Estado.PENDIENTE;
		reservas_platos = new HashSet<Reservas_Platos>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_personas() {
		return num_personas;
	}

	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
	}

	public int getNum_celiacos() {
		return num_celiacos;
	}

	public void setNum_celiacos(int num_celiacos) {
		this.num_celiacos = num_celiacos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isPara_llevar() {
		return para_llevar;
	}

	public void setPara_llevar(boolean para_llevar) {
		this.para_llevar = para_llevar;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Set<Reservas_Platos> getReservas_platos() {
		return reservas_platos;
	}

	public void setReservas_platos(Set<Reservas_Platos> reservas_platos) {
		this.reservas_platos = reservas_platos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
