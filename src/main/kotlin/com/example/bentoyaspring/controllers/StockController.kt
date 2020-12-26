package com.example.bentoyaspring.controllers

import com.example.bentoyaspring.dtos.StockRequest
import com.example.bentoyaspring.services.StockService
import com.example.bentoyaspring.utils.itemValidation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stocks")
class StockController @Autowired constructor(private val service: StockService) {
    @PostMapping
    fun create(
            @RequestBody @Validated stocks: List<StockRequest>
        ): ResponseEntity<*> {
        stocks.forEach {
            if(!itemValidation(it.item)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This item does not exist")
            }
        }

        return try {
            service.save(stocks)
            ResponseEntity.status(HttpStatus.CREATED).build<Any>()
        } catch (e: Exception) {
            println(e)
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build<Any>()
        }
    }
}