package com.example.bentoyaspring.repositories

import com.example.bentoyaspring.entities.Demand
import org.springframework.data.jpa.repository.JpaRepository

interface DemandRepository : JpaRepository<Demand, Int> {}