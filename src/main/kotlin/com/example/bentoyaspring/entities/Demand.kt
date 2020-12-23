package com.example.bentoyaspring.entities

import javax.persistence.*

@Entity
data class Demand(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @ManyToMany(cascade = [CascadeType.ALL])
        val products: List<Product>,

        @ManyToOne
        val customer: Customer
)