package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Ingrediente;

public interface IngredienteRepo extends JpaRepository<Ingrediente, Integer>{

}
