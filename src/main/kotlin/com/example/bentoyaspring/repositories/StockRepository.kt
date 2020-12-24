package com.example.bentoyaspring.repositories

import com.example.bentoyaspring.entities.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository: JpaRepository<Stock, String>{
    fun findStockById(id: String): Stock?
}