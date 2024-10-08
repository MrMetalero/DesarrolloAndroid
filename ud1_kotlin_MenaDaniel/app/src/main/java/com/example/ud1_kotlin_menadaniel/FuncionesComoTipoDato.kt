package com.example.ud1_kotlin_menadaniel

fun main(){

    val trickFunction = trick2
    trick2()
    trickFunction()
    treat()
}

val trick2 = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")

}


