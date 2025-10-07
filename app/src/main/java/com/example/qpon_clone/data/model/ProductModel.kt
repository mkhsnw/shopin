package com.example.qpon_clone.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val photoUrl: String,
    val stock: Int,
    val shopName: String,
    val shopAddress: String,
    val priceDisplay: String,
    val originalPriceDisplay: String?,
    val isDiscounted: Boolean,
    val availability: String,
    val bestBeforeDisplay: String
)