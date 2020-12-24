package com.example.bentoyaspring.dtos

import com.sun.istack.NotNull

data class StockRequest(
        @NotNull
        val name: String,
        @NotNull
        val quantity: Int,
        val value: Double? = null,
)