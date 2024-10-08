package com.example.ud1_kotlin_menadaniel

fun main(){
    val morningNotification = 51
    val eveningNotification = 135
    val child =5
    val adult = 28
    val senior = 87

    val isMonday = true


    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")

}


//Ejercicio2
fun printNotificationSummary(numberOfMessages:Int){
    when(numberOfMessages){
        in 1..100 -> println("you have $numberOfMessages notifications")
        else -> println("Your phone is blowing up! You have +99 notifications")
    }

}


//Ejercicio 3
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    var resultado:Int = 0
    when(age){
        in 1..5 -> resultado = 15
        in 6..28 -> if (isMonday){resultado = 25}else{resultado = 30}
        in 29..61 -> resultado = 15
        else -> return -1
    }
    return resultado
}








