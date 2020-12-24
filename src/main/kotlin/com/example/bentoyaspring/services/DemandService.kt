package com.example.bentoyaspring.services

import com.example.bentoyaspring.dtos.DemandRequest

interface DemandService {
    fun save(demand: List<DemandRequest>)
}