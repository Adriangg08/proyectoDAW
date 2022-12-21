package main.aplicacion.stock;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepo extends JpaRepository<Stock, Integer>{

}
