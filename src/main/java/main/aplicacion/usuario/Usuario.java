package main.aplicacion.usuario;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import main.aplicacion.roles.Rol;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name= "password")
	private String password;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = {@JoinColumn(name = "id_usuario")},
			inverseJoinColumns = {@JoinColumn(name = "id_rol")}
	)
	@JsonIgnore
	private Set<Rol> roles;
	
	public Usuario() {
		roles = new HashSet<Rol>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	/*Si uso username deberia ponerle al getUsername() la etiqueta @Override para q utilize este metodo y no el de Spring*/
	
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
