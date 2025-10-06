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
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qpon_clone.R
import com.example.qpon_clone.components.EmailTextField
import com.example.qpon_clone.components.FullnameTextfield
import com.example.qpon_clone.components.PasswordTextField
import com.example.qpon_clone.components.PrimaryButton
import com.example.qpon_clone.view_model.AuthViewModel

@Composable
fun SignupScreen(modifier: Modifier = Modifier, navController: NavHostController, viewModel: AuthViewModel = AuthViewModel()) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var fullname by remember {
        mutableStateOf("")
    }

//    var isLoading by remember { mutableStateOf(false) }
//    var errorMessage by remember { mutableStateOf("") }
//    val registerResponse = viewModel.registerResponse.observeAsState()

//    LaunchedEffect(registerResponse.value) {
//        when (registerResponse.value) {
//            is NetworkResponse.Loading -> {
//                isLoading = true
//                errorMessage = ""
//            }
//            is NetworkResponse.Success -> {
//                isLoading = false
//                navController.navigate("login")
//            }
//            is NetworkResponse.Failed -> {
//                isLoading = false
//                errorMessage = (registerResponse.value as NetworkResponse.Failed).message
//            }
//            null -> {
//                isLoading = false
//            }
//        }
//    }


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(30.dp)
    ) {
        Text(text = "Hi There", style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        ))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Let`s Create an Account !!", style = TextStyle(
            textMotion = TextMotion.Animated,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        ))
        Spacer(modifier = Modifier.height(20.dp))
        Image(painterResource(id = R.drawable.signup), contentDescription = "Gambar buat signup", modifier = Modifier.fillMaxWidth().height(200.dp))
        Spacer(modifier = Modifier.height(20.dp))
        EmailTextField(modifier, value = email, onValueChange = { email = it}, isError = false)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(modifier, value = password, onValueChange = {password = it}, isError = false)
        Spacer(modifier = Modifier.height(10.dp))
        FullnameTextfield(modifier, value = fullname, onValueChange = { fullname = it}, isError = false)
        Spacer(modifier = Modifier.height(20.dp))
        PrimaryButton(modifier, "Register", {
//            if (email.isNotBlank() && password.isNotBlank() && fullname.isNotBlank()) {
//                viewModel.register(fullname, email, password)
//            } else {
//                errorMessage = "Please fill all the fields"
//            }
        })
//        if(errorMessage.isNotBlank()){
//            ErrorText(modifier, errorMessage)
//        }
    }
}