package com.example.logininstagramcompose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InstaLogin() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Logo
        Image(
            painter = painterResource(R.drawable.instagram),
            contentDescription = "Letras de Instagram",
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        )

        //Campos de texto username y para el password
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Username or email") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Button(modifier = Modifier
                        .background(
                            color = Color.Transparent
                        ),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Gray

                        )


                    ) { Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Toggle Password Visibility"
                    )}

                }
            )

            Spacer(modifier = Modifier
                .height(8.dp))

            Text(
                text = "Forgot password?",
                color = colorResource(R.color.instaBlue),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.End)
            )
        }

        // Login
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
               containerColor = colorResource(R.color.instaBlue)
            )
        ) {
            Text(
                text = "Log In",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier
            .height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.LightGray
            )
            Text(
                text = "OR",
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                thickness = 1.dp,
                color = Color.LightGray
            )
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.fb),
                contentDescription = "Icono de Facebook",
                modifier = Modifier
                    .size(28.dp)
            )
            TextButton(
                onClick = {  },
                modifier = Modifier

                    .height(50.dp)
                    .background(color = Color.Transparent)
            ){
                TextButton (
                    onClick = {},

                ){
                    Text(
                        text = "Continue as Cave Johnson",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.instaBlue)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))



        TextButton(
            onClick = {},
        ){
            Text(
                text = "Don't have an account? Sign Up.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
        }
    }
}
