package com.example.qpon_clone.screen

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qpon_clone.components.CategoryItem
import com.example.qpon_clone.components.PromoCardItem
import com.example.qpon_clone.components.PromoItemCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    val showSticktFilters by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex >= 6
        }
    }
    Scaffold (
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary),
        bottomBar = {
            NavigationBar (
                containerColor = MaterialTheme.colorScheme.surface
            ){
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.Place, contentDescription = null) },
                    label = { Text("Explore") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    label = { Text("Order") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                    label = { Text("Account") }
                )
            }
        },
        topBar = {
            Column (
                Modifier.background(Color(0xFF00A99D)),
            ){
                TopAppBar(
                    title =
                        {
                            Row (
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "QPON", color = MaterialTheme.colorScheme.onPrimary)
                                Spacer(Modifier.weight(1f))
                                Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = MaterialTheme.colorScheme.onPrimary, modifier = modifier.padding(4.dp))
                                Text(
                                    text = "Failed to locate",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = modifier.padding(4.dp)
                                )
                                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null,modifier.padding(4.dp))
                            }
                        },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF00A99D)
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("Find the best spots & deals near you", style = MaterialTheme.typography.bodyMedium) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.clip(
                            RoundedCornerShape(50))
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(8.dp)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        focusedContainerColor = MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(50)
                )
                Spacer(Modifier.height(10.dp))
            }
        },
        containerColor = Color(0xFF00A99D)
    ) {
        paddingValues ->
        LazyColumn (
            state = scrollState,
            modifier = Modifier.padding(paddingValues).fillMaxSize().clip(RoundedCornerShape(topStart = 20.dp, topEnd =  20.dp )).background(
                MaterialTheme.colorScheme.background
            ),
            contentPadding = PaddingValues(bottom = 16.dp),
        ) {
            item {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(24.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surface),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    CategoryItem("🥤", "Drinks")
                    CategoryItem("🍔", "Food")
                    CategoryItem("👥", "Group")
                    CategoryItem("🎉", "Fun & Relax")
                }
            }

            item {
                Row (
                    modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background).padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                )
                {
                    Card (
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor =  Color(0xFFFFFFFF))
                    ) {
                        Row (
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier.weight(1f),
                            ){
                                Text("Qpon Choice", style = MaterialTheme.typography.bodyMedium)
                                Text("Qpon Choice", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }

                    Card (
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor =  Color(0xFFFFFFFF))
                    ) {
                        Row (
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier.weight(1f),
                            ){
                                Text("Qpon Choice", style = MaterialTheme.typography.bodyMedium)
                                Text("Qpon Choice", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }

            item {
                LazyRow (
                    modifier = Modifier.fillMaxWidth().padding(6.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    item {
                        PromoCardItem(
                            title = "Bestie Price",
                            subtitle = "Try Now!",
                            backgroundColor = Color(0xFFFDD835)
                        )
                    }
                    item {
                        PromoCardItem(
                            title = "Flash Sale",
                            subtitle = "Up to\n60% off",
                            backgroundColor = Color(0xFFE91E63),
                            timer = "03:28:09"
                        )
                    }
                    item {
                        PromoCardItem(
                            title = "Brand",
                            subtitle = "Great Offers",
                            backgroundColor = Color(0xFFFF5722)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                Text("Nearby Promos", fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 24.dp))
            }

            item {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                )
                {
                    FilterChip(
                        selected = false,
                        onClick = {},
                        label = { Text("Categories", style = MaterialTheme.typography.bodySmall) },
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                        }
                    )
                    FilterChip(
                        selected = false,
                        onClick = {},
                        label = { Text("Categories", style = MaterialTheme.typography.bodySmall) },
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                        }
                    )
                    FilterChip(
                        selected = false,
                        onClick = {},
                        label = { Text("Categories", style = MaterialTheme.typography.bodySmall) },
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                        }
                    )
                }
            }

            items(10) { index ->
                PromoItemCard(
                    restaurantName = if (index % 2 == 0) "KFC Pasaraya Manggarai" else "XXI CAFE METROPOLE",
                    rating = if (index % 2 == 0) "4.4" else "4.6",
                    category = if (index % 2 == 0) "Fast Food" else "Coffee",
                    discount = "-8%",
                    originalPrice = "Rp. 50.000",
                    discountedPrice = "Rp. 46.000"
                )
            }
        }
    }
}