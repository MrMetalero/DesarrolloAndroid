package com.example.ud1_kotlin_menadaniel

fun main(){
    val kelvinNumber = 340.0
    val celsiusNumber = 31.0
    val fahrenheitNumber = 135.0

    printFinalTemperature(340.0,"C","F") {
        initialMeasurement ->  (initialMeasurement*1.8) + 32
    }
    printFinalTemperature(31.0,"C","K") {
        initialMeasurement ->  (initialMeasurement- 273.15)
    }

    printFinalTemperature( 135.0,"F","K") {
        InitialMeasurement -> (InitialMeasurement-32)/1.8 + 273

    }


}




//Ejercicio 4

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
){
    val finalMeasurement = String.format ("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
