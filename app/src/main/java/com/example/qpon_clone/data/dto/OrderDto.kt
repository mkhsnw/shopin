package com.example.qpon_clone.data.dto

import com.google.gson.annotations.SerializedName

data class OrderDto(
    @SerializedName("id") val id: Int,
    @SerializedName("pickup_code") val pickupCode: String,
    @SerializedName("status") val status: String,
    @SerializedName("total_price") val totalPrice: Double,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("items_count") val itemsCount: Int,
    @SerializedName("shop") val shop: ShopShortDto,
    @SerializedName("items_preview") val itemsPreview: List<OrderItemPreviewDto>
)

data class ShopShortDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class OrderItemPreviewDto(
    @SerializedName("product_id") val productId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("qty") val qty: Int,
    @SerializedName("price_at") val priceAt: Double,
    @SerializedName("subtotal") val subtotal: Double,
    @SerializedName("photo_url") val photoUrl: String
)