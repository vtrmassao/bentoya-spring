package com.example.bentoyaspring.entities

import javax.persistence.*

@Entity
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @ManyToOne
        val name: Stock,

        @Column(nullable = false)
        val quantity: Int,
)
