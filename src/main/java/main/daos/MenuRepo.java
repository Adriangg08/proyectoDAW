package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Menu2;

public interface MenuRepo extends JpaRepository<Menu2, Integer>{

}
