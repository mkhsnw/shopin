package com.example.qpon_clone.model

import com.google.gson.annotations.SerializedName

data class ShopsResponse<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("meta")
    val meta: Meta?
)

data class Shop(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("opening_hours")
    val openingHours: String,
    @SerializedName("closing_hours")
    val closingHours: String,
    @SerializedName("photo_url")
    val photoUrl: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("address_name")
    val addressName: String,
    @SerializedName("address_url")
    val addressUrl: String,
    @SerializedName("distance")
    val distance: Double,
    @SerializedName("distance_unit")
    val distanceUnit: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("fk_user_id")
    val fkUserId: Int
)




