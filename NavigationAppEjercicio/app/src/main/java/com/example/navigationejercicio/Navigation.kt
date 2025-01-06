package com.example.navigationejercicio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationejercicio.screens.LoginScreen
import com.example.navigationejercicio.screens.GameScreen
import com.example.navigationejercicio.screens.ResultScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    //Controla la navegación entre las diferentes screens
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("game/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: "Guest"
            GameScreen(navController, username)
        }
        composable("result/{number}/{intentos}") { backStackEntry ->
            val number = backStackEntry.arguments?.getString("number")?.toIntOrNull() ?: 1
            val attempts = backStackEntry.arguments?.getString("intentos")?.toIntOrNull() ?: 1
            ResultScreen(navController, number, attempts)
        }
    }
}
