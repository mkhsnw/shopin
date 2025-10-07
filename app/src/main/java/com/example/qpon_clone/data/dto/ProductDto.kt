package com.example.qpon_clone.data.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("best_before_date") val bestBeforeDate: String,
    @SerializedName("stock") val stock: Int,
    @SerializedName("original_price") val originalPrice: Double,
    @SerializedName("discounted_price") val discountedPrice: Double,
    @SerializedName("shop_id") val shopId: Int,
    @SerializedName("shop") val shop: List<ShopProductDto>,
    @SerializedName("display") val display: DisplayDto
)

data class ProductDetailDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("best_before_date") val bestBeforeDate: String,
    @SerializedName("stock") val stock: Int,
    @SerializedName("original_price") val originalPrice: Double,
    @SerializedName("discounted_price") val discountedPrice: Double,
    @SerializedName("shop_id") val shopId: Int,
    @SerializedName("shop") val shop: ShopProductDto,
    @SerializedName("display") val display: DisplayDto
)

data class ShopProductDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("photo_url") val photoUrl: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("address_name") val addressName: String
)

data class DisplayDto(
    @SerializedName("price_display") val priceDisplay: String,
    @SerializedName("original_price_display") val originalPriceDisplay: String,
    @SerializedName("is_discounted") val isDiscounted: Boolean,
    @SerializedName("discount_percentage") val discountPercentage: Int,
    @SerializedName("availability") val availability: String,
    @SerializedName("best_before_display") val bestBeforeDisplay: String
)