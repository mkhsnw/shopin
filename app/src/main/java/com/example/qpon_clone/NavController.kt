package com.example.qpon_clone

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qpon_clone.screen.AuthScreen
import com.example.qpon_clone.screen.HomeScreen
import com.example.qpon_clone.screen.LoginScreen
import com.example.qpon_clone.screen.SignupScreen

@Composable
fun NavController(modifier: Modifier){
    val navController = rememberNavController()
    GlobalNavigation.navController = navController

    NavHost(navController = navController, startDestination = "auth") {
        composable("home") {
            HomeScreen()
        }

        composable("auth") {
            AuthScreen(modifier,navController)
        }

        composable("login") {
            LoginScreen(navController = navController)
        }

        composable("register") {
            SignupScreen(navController = navController)
        }
    }
}

object GlobalNavigation {
    lateinit var navController: NavController
}