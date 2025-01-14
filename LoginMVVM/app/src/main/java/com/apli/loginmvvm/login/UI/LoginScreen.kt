package com.apli.loginmvvm.login.UI


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Body(modifier: Modifier, loginVM: LoginViewModel) {
    val email by rememberSaveable {
        mutableStateOf("")
    }
    val password by rememberSaveable {
        mutableStateOf("")
    }
    val isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }
}

@Composable
fun HeaderComponent(mod: Modifier) {

}

@Composable
fun Footer(mod: Modifier) {

}

@Composable
fun Body(mod: Modifier) {

}

@Composable
fun LoginScreen(loginVM: LoginViewModel) {
    Box(
        Modifier
            .
            fillMaxSize()
            .
            padding(8.
            dp)
    ) {
        HeaderComponent(Modifier.
        align(Alignment.TopEnd))
        Body(Modifier.
        align(Alignment.Center), loginVM)
        Footer(Modifier.
        align(Alignment.BottomCenter))
    }
}




