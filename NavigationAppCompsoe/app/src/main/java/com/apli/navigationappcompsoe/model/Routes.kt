package com.apli.navigationappcompsoe.model

sealed class Routes(val route:String){
    object PantallaA:Routes("screen_a")
    object PantallaB:Routes("screen_b")

}