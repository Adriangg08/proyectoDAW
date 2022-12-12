package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Stock2;


public interface StockRepo extends JpaRepository<Stock2, Integer>{

}
