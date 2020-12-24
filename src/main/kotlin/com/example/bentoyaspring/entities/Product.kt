package com.example.bentoyaspring.entities

import javax.persistence.*

@Entity
data class Product(
        @ManyToOne(cascade = [CascadeType.ALL])
        val stock: Stock,

        @Column(nullable = false)
        val quantity: Int,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
)
