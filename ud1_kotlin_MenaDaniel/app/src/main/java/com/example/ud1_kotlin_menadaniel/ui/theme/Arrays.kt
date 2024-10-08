package com.example.ud1_kotlin_menadaniel.ui.theme

fun main(){
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays.size)

    for (pos in weekDays.indices){ // parecido a foreach pero INDICES
        print("$pos:")
        println(weekDays[pos])
    }


    println()
    println()
    for (day in weekDays) print ("$day,") //Foreach


    val lista:MutableList<String> = mutableListOf("a", "b", "c")

    lista.filter { it.contains("b") }

}