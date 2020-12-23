package com.example.bentoyaspring.entities

import javax.persistence.*

@Entity
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false, unique = true)
        val phone: String,
)
