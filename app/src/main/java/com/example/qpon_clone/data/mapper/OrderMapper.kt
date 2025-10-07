package com.example.qpon_clone.data.mapper

import com.example.qpon_clone.data.dto.ProductDetailDto
import com.example.qpon_clone.data.model.Product

fun ProductDetailDto.toDomainModel(): Product {
    return Product(
        id = this.id,
        name = this.name,
        description = this.description,
        photoUrl = this.photoUrl,
        stock = this.stock,
        shopName = this.shop.name,
        shopAddress = this.shop.addressName,
        priceDisplay = this.display.priceDisplay,
        originalPriceDisplay = this.display.originalPriceDisplay,
        isDiscounted = if(this.discountedPrice > 0) true else false,
        availability = this.display.availability,
        bestBeforeDisplay = this.display.bestBeforeDisplay
    )
}