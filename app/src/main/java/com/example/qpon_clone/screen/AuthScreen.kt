package com.example.qpon_clone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qpon_clone.R
import com.example.qpon_clone.components.PrimaryButton
import com.example.qpon_clone.components.SecondaryButton

@Composable
fun AuthScreen(modifier: Modifier = Modifier, navController: NavHostController,) {
    Surface {
        Box(Modifier.fillMaxSize()){
            Column (modifier = modifier
                .fillMaxSize()
                .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(painter = painterResource(id = R.drawable.creative), contentDescription = "Gambar buat homepage",modifier = Modifier.fillMaxWidth().height(300.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Shopin", style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Feel free to shop here, Happy Shopping!!", style = TextStyle(
                    textMotion = TextMotion.Animated,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center
                ))
                Spacer(modifier = Modifier.height(20.dp))
                PrimaryButton(modifier, "Login", {
                    navController.navigate("login")
                })
                Spacer(modifier = Modifier.height(20.dp))
                SecondaryButton(modifier, "Sign Up", {
                    navController.navigate("register")
                })
            }
        }
    }
}