package com.example.qpon_clone.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.qpon_clone.R
import com.example.qpon_clone.components.EmailTextField
import com.example.qpon_clone.components.FullnameTextfield
import com.example.qpon_clone.components.PasswordTextField
import com.example.qpon_clone.components.PrimaryButton
import com.example.qpon_clone.remote.Result
import com.example.qpon_clone.view_model.AuthViewModel

@Composable
fun SignupScreen(modifier: Modifier = Modifier, navController: NavHostController, viewModel: AuthViewModel = viewModel()) {

    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var fullname by remember {
        mutableStateOf("")
    }

    val registerResponse by viewModel.registerResponse.observeAsState()
    val isLoading = registerResponse is Result.Loading

    LaunchedEffect(registerResponse) {
        when (registerResponse) {
            is Result.Success -> {
                Toast.makeText(context, "Register Success, Please Login", Toast.LENGTH_SHORT).show()
                navController.navigate("login") {
                    popUpTo("register") { inclusive = true }
                }
            }
            is Result.Error -> {
                val errorMessage = (registerResponse as Result.Error).exception.message
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
            is Result.Loading -> {}
            null -> {}
        }
    }


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
            viewModel.register(email = email, password = password, name = fullname)
        })
//        if(errorMessage.isNotBlank()){
//            ErrorText(modifier, errorMessage)
//        }
    }
}