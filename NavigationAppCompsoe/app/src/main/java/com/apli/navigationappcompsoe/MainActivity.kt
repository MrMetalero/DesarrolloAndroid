package com.apli.navigationappcompsoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaN
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.apli.navigationappcompsoe.model.Routes
import com.apli.navigationappcompsoe.model.Routes.*
import com.apli.navigationappcompsoe.ui.theme.NavigationAppCompsoeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
                InitNavController()

        }


    }

    @Composable
    fun InitNavController(){
        val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = PantallaA
            ) {
                // Selecciono el nombre de la ruta sac�ndolo de route con el enum
                // y le asigno por lambda el valor de su correspondiente Screen
                composable(PantallaA.route) { ScreenA(navController)}
                composable(PantallaB.route) { ScreenB(navController)}

            }

    }






}



