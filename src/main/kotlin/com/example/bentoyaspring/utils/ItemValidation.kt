package com.example.bentoyaspring.utils

fun itemValidation(item: String): Boolean {
    return try {
        MenuItems.values().contains(MenuItems.valueOf(item))
    } catch (e: Exception) {
        false
    }
}