package com.example.bentoyaspring.entities

import com.example.bentoyaspring.dtos.enums.PaymentType
import org.hibernate.annotations.CreationTimestamp
import java.util.*
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

        @Column
        val freight: Double,

        @Column
        val discount: Double,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column
        @CreationTimestamp
        val createdAt: Date? = null,
)