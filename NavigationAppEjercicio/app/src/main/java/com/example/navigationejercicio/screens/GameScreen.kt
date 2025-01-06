package com.example.navigationejercicio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationejercicio.R

@Composable
fun GameScreen(navController: NavController, username: String) {
    var sliderValue by remember { mutableFloatStateOf(1f) }
    var intentos by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                color = colorResource(id = R.color.transparentCyan)

            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hola, $username", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Selecciona un número:")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 1f..10f,
            steps = 9,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = "Número seleccionado: ${sliderValue.toInt()}")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = intentos,
            onValueChange = { intentos = it },
            label = { Text("Número de intentos") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            when {
                intentos.isNotEmpty() && intentos.all { it.isDigit() } -> {
                    // Si no está vacío y contiene solo números, navega a resultados
                    navController.navigate("result/${sliderValue.toInt()}/${intentos.toInt()}")
                }
                intentos.isEmpty() -> {
                    // Si está vacío, muestra un mensaje de error
                    dialogMessage = "El campo de intentos no puede estar vacío."
                    showDialog = true
                }
                else -> {
                    // Si contiene letras u otros caracteres inválidos, muestra un mensaje de error
                    dialogMessage = "Solo se permiten números en el campo de intentos."
                    showDialog = true
                }
            }
        }) {
            Text("Jugar")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Error") },
                text = { Text(dialogMessage) },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Ok")
                    }
                }
            )
        }
    }
}
