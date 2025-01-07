package com.example.navigationejercicio.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random


//TENÍA UN BUG QUE ME HA COSTADO UN RATO LARGO ARREGLAR. RECORDAR USAR MUTABLESTATEOF PARA QUE
//COMPOSE AL ACTUALIZAR UN ELEMENTO RECUERDE EL ESTADO DE LAS VARIABLES AL RECARGAR UNA PÁGINA
@Composable
fun ResultScreen(navController: NavController, number: Int, intentos: Int) {
    var randomNumber = generateRandomNumber()
    var resultado by remember { mutableStateOf("") }
    var numeroAcertado by remember { mutableStateOf(false) }
    var recorridoHecho by remember { mutableStateOf(false) }

    //Habia otro bug que necesitaba arreglar. El composable no me dejaba cambiar las variables para que
    //este trozo de codigo deje de ejecutarse cada vez que se redibuja. De forma que he tenido que usar
    //LaunchedEffect, que he visto que me sirve para esto. Los mutableState si se estan guardando con los
    //valores que tocan ahora
    //Otra posible solucion puede ser utilizar val currentNumeroAcertado = rememberUpdatedState(numeroAcertado) ????
    //Tengo que comprobarlo

    LaunchedEffect(numeroAcertado) {
        if (!numeroAcertado) {
            for (i in 1..intentos) {
                randomNumber = generateRandomNumber()
                if (number == randomNumber) {
                    resultado = "Número acertado en el intento $i mi rey"
                    numeroAcertado = true
                    break
                } else {
                    resultado = "No hay acierto. El número era $randomNumber Troste"
                }
            }
            recorridoHecho = true
        }
    }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = resultado, style = MaterialTheme.typography.displaySmall)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("login") }) {
                Text("Volver al inicio")
            }
        }
    }




fun generateRandomNumber(): Int {
    return Random.nextInt(1, 11)
}






