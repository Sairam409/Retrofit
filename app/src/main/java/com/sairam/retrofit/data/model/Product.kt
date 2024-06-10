package com.sairam.retrofit.data.model

data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val stock: Int,
    val thumbnail: String,
    val title: String,
    val rating: Double
)
