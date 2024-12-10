package com.apli.composeprimeraapp1

import android.os.Bundle
import android.provider.Contacts
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.apli.composeprimeraapp1.ui.theme.ComposePrimeraApp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePrimeraApp1Theme {

                Column(horizontalAlignment =  Alignment.CenterHorizontally,
                    modifier =  Modifier.padding(40.dp,20.dp)
                ) {

                }

            }
        }

    }



}

//ColorResource(R.color.XXXX) Para pillar colores desde XML

@Preview
@Composable
fun ConstraintExample2(){
    ConstraintLayout( modifier = Modifier.fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {


            Text("Título",
                fontSize = 50.sp,
                textAlign = TextAlign.Center  ,
                modifier = Modifier
                    .fillMaxWidth()


            )

            Text("Subtítulo",
                fontSize = 20.sp,
                textAlign = TextAlign.Center  ,
                modifier = Modifier
                    .fillMaxWidth()


            )

            Row( modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceEvenly

            ) {
                Text("Opción 1",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )

                Text("Opción 2",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )

                Text("Opción 3",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )





            }

            Row( modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceEvenly

            ) {
                Text("Opción 1",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )

                Text("Opción 2",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )

                Text("Opción 3",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center  ,
                    modifier = Modifier



                )





            }
            
        }

    }

}









