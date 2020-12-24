package com.example.bentoyaspring.entities

import com.example.bentoyaspring.dtos.enums.PaymentType
import javax.persistence.*

@Entity
data class Demand(
        @Column
        @Enumerated(EnumType.STRING)
        val paymentType: PaymentType,

        @ManyToMany(cascade = [CascadeType.ALL])
        val products: List<Product?>,

        @ManyToOne(cascade = [CascadeType.ALL])
        val customer: Customer,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
)