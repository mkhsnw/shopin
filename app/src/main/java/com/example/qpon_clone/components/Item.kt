package com.example.qpon_clone.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(emoji: String, label: String, hasDiscount: Boolean = false) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(70.dp)
    ) {
        Box {
            Text(emoji, fontSize = 32.sp)
            if (hasDiscount) {
                Surface (
                    modifier = Modifier.align(Alignment.TopEnd),
                    color = Color(0xFFE91E63),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        "Rp7k",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        }
        Spacer(Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
fun PromoCardItem(
    title: String,
    subtitle: String,
    backgroundColor: Color,
    timer: String? = null
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                if (timer != null) {
                    Surface(
                        color = Color(0xFFFDD835),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            timer,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                }
                Text(
                    title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (backgroundColor == Color(0xFFFDD835)) Color.Black else Color.White
                )
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (backgroundColor == Color(0xFFFDD835)) Color.Black else Color.White
                )
            }
        }
    }
}

@Composable
fun PromoItemDetail(originalPrice: String, discount: String, discountedPrice: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5))
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF00A99D))
        )
        Text(originalPrice, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Text(discount, fontSize = 10.sp, color = Color(0xFFE91E63))
    }
}

@Composable
fun PromoItemCard(
    restaurantName: String,
    rating: String,
    category: String,
    discount: String,
    originalPrice: String,
    discountedPrice: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            // Restaurant Image Placeholder
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF00A99D))
            )

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    restaurantName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⭐", fontSize = 12.sp)
                    Text("$rating | $category", fontSize = 14.sp, color = Color.Gray)
                }

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PromoItemDetail(originalPrice, discount, discountedPrice)
                    PromoItemDetail(originalPrice, discount, discountedPrice)
                }
            }
        }
    }
}