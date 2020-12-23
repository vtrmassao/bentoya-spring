package com.example.bentoyaspring.services

import com.example.bentoyaspring.entities.Demand

interface DemandService {
    fun save(demand: List<Demand>)
}