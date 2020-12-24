package com.example.bentoyaspring.dtos

import com.sun.istack.NotNull

data class DemandRequest(
        @NotNull
        val phone: String,
        @NotNull
        val name: String,
        @NotNull
        val paymentType: String,
        @NotNull
        val products: List<ProductRequest>,
)
