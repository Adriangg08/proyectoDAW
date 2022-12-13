package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Plato;

public interface PlatoRepo extends JpaRepository<Plato, Integer>{

}
