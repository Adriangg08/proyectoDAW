package main.aplicacion.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario,Integer>{

	Optional<Usuario> findByNombre(String nombre);

}
