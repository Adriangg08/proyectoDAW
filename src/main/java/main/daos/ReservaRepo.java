package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Reserva;

public interface ReservaRepo extends JpaRepository<Reserva, Integer>{

}
