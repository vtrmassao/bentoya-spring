package com.example.bentoyaspring.services

import com.example.bentoyaspring.entities.Demand
import com.example.bentoyaspring.repositories.DemandRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class DemandServiceImpl @Autowired constructor(private val repository: DemandRepository): DemandService{
    override fun save(demand: List<Demand>) {
        repository.saveAll(demand)
    }
}