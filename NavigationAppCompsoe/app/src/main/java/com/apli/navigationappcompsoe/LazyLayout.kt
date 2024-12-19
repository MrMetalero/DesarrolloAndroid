package com.apli.navigationappcompsoe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class LazyLayout {

    @Preview(showBackground = true)
    @Composable
    fun MyLazyLayout(){
        val myList = listOf("Dani", "Javi", "Ivan", "David")
        Column(modifier = Modifier.fillMaxWidth()){
            LazyRow {
                item{Text(text = "Hola1")}
                item{Text(text = "Hola2")}
                items(myList){
                    Text(text = "Este es el item $it")
                }

            }
            LazyColumn {
                items(7){
                    Text(text =  "Este es el item ${it+1}")
                }
            }
        }
    }


}