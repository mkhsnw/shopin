package com.example.qpon_clone.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.qpon_clone.R
import com.example.qpon_clone.components.EmailTextField
import com.example.qpon_clone.components.PasswordTextField
import com.example.qpon_clone.components.PrimaryButton
import com.example.qpon_clone.remote.Result
import com.example.qpon_clone.view_model.AuthViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier, viewModel: AuthViewModel = viewModel(), navController : NavController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    val loginResponse by viewModel.loginResponse.observeAsState()
    val isLoading = loginResponse is Result.Loading

    LaunchedEffect(loginResponse) {
        if (loginResponse is Result.Success) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    )
    {
        Text(text = "sign in to your account", style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        ))
        Spacer(modifier = Modifier.height(20.dp))
        Image(painterResource(id = R.drawable.signup), contentDescription = "Gambar buat signup", modifier = Modifier
            .fillMaxWidth()
            .height(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        EmailTextField(modifier, value = email, onValueChange = { email = it}, isError = false)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(modifier, value = password, onValueChange = {password = it}, isError = false)
        Spacer(modifier = Modifier.height(20.dp))
        PrimaryButton(modifier, "login", {
            viewModel.login(email,password)
        },
            loading = isLoading)
    }
}