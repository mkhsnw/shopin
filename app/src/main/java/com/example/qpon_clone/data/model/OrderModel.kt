package com.example.qpon_clone.data.model

import com.google.gson.annotations.SerializedName

data class OrderItem(
    val productName: String,
    val quantity: Int,
    val photoUrl: String
)


data class Order(
    val id: Int,
    val pickupCode: String,
    val status: String,
    val totalPriceDisplay: String,
    val orderDate: String,
    val totalItems: Int,
    val shopName: String,
    val itemsPreview: List<OrderItem>
)