package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Carta;

public interface CartaRepo extends JpaRepository<Carta, Integer>{

}
