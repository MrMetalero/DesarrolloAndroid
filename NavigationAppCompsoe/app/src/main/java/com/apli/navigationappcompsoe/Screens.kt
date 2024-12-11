package com.apli.navigationappcompsoe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun ScreenA(navController: NavController){
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pantalla A")
        Button(
            onClick = {navController.navigate("screenB")}
        ) {
            Text("Ir a la pantalla B")
        }

    }

}



@Composable
fun ScreenB(navController: NavController){
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Pantalla B")
        Button(
            onClick = {navController.navigateUp()}
        ){
            Text("Regresar a la Pantalla A")
        }
    }
}