package main.web.reserva;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import main.web.reserva_plato.Reservas_Platos;


enum Estado {
	PENDIENTE,PROCESO,COMPLETADO;
}

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "num_personas")
	private int num_personas;
	
	@Column(name = "num_celiacos")
	private int num_celiacos;
	
	@Column(name = "estado")
	private Estado estado;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "para_llevar")
	private boolean para_llevar;
	
	@Column(name = "fecha_reserva")
	private Date fecha_reserva;
	
//	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
//	@JoinTable(
//			name = "platos_reservas", 
//			joinColumns = {@JoinColumn(name = "id_reserva")}, 
//			inverseJoinColumns = {@JoinColumn(name = "id_plato")}
//		)
//	private Set<Plato> platos;
	
	@OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "plato")
	private Set<Reservas_Platos> reservas_platos;

	public Reserva() {
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

//	public Set<Plato> getPlatos() {
//		return platos;
//	}
//
//	public void setPlatos(Set<Plato> platos) {
//		this.platos = platos;
//	}

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
	
	public Reserva persist(ReservaDTO r) {
		this.id = r.getId();
		this.nombre = r.getNombre();
		this.telefono = r.getTelefono();
		this.mail = r.getMail();
		this.num_celiacos = r.getNum_celiacos();
		this.num_personas = r.getNum_personas();
		this.estado = r.getEstado();
		this.comentario = r.getComentario();
		this.para_llevar = r.isPara_llevar();
		this.fecha_reserva = r.getFecha_reserva();
		this.reservas_platos = r.getReservas_platos();
		
		return this;
	}
	
}
