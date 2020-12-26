package com.example.bentoyaspring.services

import com.example.bentoyaspring.dtos.StockRequest
import com.example.bentoyaspring.entities.Stock
import com.example.bentoyaspring.repositories.StockRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class StockServiceImpl @Autowired constructor(private val repository: StockRepository) : StockService {
    override fun save(stocks: List<StockRequest>) {
        stocks.forEach {
            val stock = repository.findStockById(it.item)

            if(stock != null) {
                val newValue = it.value ?: stock.value
                repository.save(Stock(it.item, stock.quantity?.plus(it.quantity), newValue))
            } else {
                if(it.value != null) {
                    repository.save(Stock(it.item, it.quantity, it.value))
                }
            }
        }
    }
}