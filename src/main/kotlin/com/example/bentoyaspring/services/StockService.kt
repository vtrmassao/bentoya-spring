package com.example.bentoyaspring.services

import com.example.bentoyaspring.dtos.StockRequest

interface StockService {
    fun save(stocks: List<StockRequest>)
}