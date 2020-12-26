package com.example.bentoyaspring.entities

import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
data class Stock(
        @Id
        val id: String,

        @Column
        val quantity: Int? = null,

        @Column
        val value: Double? = null,

        @Column
        @UpdateTimestamp
        val updatedAt: Date? = null,
)
