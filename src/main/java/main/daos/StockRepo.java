package main.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Stock;


public interface StockRepo extends JpaRepository<Stock, Integer>{

}
