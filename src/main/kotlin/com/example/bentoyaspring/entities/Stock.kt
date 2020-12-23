package com.example.bentoyaspring.entities

import com.example.bentoyaspring.MenuItems
import java.util.*
import javax.persistence.*

@Entity
data class Stock(
        @Id
        @Enumerated(EnumType.STRING)
        val name: MenuItems,

        @Column
        val quantity: Int,

        @Column
        val value: Double,

        @Column
        val updatedAt: Date,
)
