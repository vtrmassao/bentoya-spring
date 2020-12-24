package com.example.bentoyaspring.dtos

import com.sun.istack.NotNull

data class ProductRequest (
    @NotNull
    val quantity: Int,

    @NotNull
    val item: String
)