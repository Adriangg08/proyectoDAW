package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import main.model.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

}
