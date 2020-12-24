package com.example.bentoyaspring.repositories

import com.example.bentoyaspring.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Int> {
    fun findCustomerByPhone(phone: String) : Customer?
}