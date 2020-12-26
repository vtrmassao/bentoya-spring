package com.example.bentoyaspring.controllers

import com.example.bentoyaspring.dtos.DemandRequest
import com.example.bentoyaspring.services.DemandService
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
@RequestMapping("/demands")
class DemandController @Autowired constructor(private val service: DemandService) {
    @PostMapping
    fun create(
            @RequestBody @Validated demands: List<DemandRequest>
    ): ResponseEntity<*> {
        for (demand in demands) {
            for (product in demand.products) {
                if(!itemValidation(product.item)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This item does not exist")
                }
            }
        }

        return try {
            service.save(demands)
            ResponseEntity.status(HttpStatus.CREATED).build<Any>()
        } catch (e: Exception) {
            println(e)
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build<Any>()
        }
    }
}