package com.example.ud1_kotlin_menadaniel

import androidx.compose.runtime.sourceInformation
import androidx.compose.ui.text.toUpperCase

fun main(){
    println("Hola clase")
    numericas()
    alfanum()
    logicas()
    println("Resultado de showMyName: " + showMyName("Daniel"))
    println("Resultado de showMyNameAndAge: " + showMyNameAndAge("Daniel",27))
    println("Resultado = "+multyInline(5,2))
    println("Resultado division = "+divideInline(10,5))
    getSem(11);
    result('d')
    result("dadada")
    result(23)
    println(resultOp(12))
    println(resultOp(true))
    println(resultOp("Hey"))
    println(resultOp2("Oyoyoy"))

}

fun logicas(){
    //Boolean
    val trueOrFalse:Boolean = true
    val ttf = false
    println("Primera $trueOrFalse Segunda  $ttf")

    // Operaciones
    var nueva = trueOrFalse
    nueva = ttf
    println("$nueva")



}

fun alfanum(){
    // CHAR
    val myChar = 'u'

    //STRING
    var myString = "string"
    val name = "Dani"
    println(myString + " " + name )

    var msg = "Mi nombre es: $name"
    println(msg)

    println("Soy en mayusculas: ${name.uppercase()}")


}

fun numericas(){
    //Int
    val age:Int = 38;
    val age2 = 30
    var age3 = 30
    //age2 = 40 NO SE PUEDE

    println(age)
    println(age3)
    age3 = age+age2
    println(age3+10)

    //LONG
    val superficie:Long = 1233325424
    val super2 = 2147483648

    //FLOAT / DOUBLE

    var volumen:Float = 10.5f
    var volumen3 = 10.5
    var volumen2 = 10.5f
    var volumen4:Double = 10.5
    println(volumen+volumen3)

}

fun showMyName(name:String):Int{
    println(name)

    return 1
}
fun showMyNameAndAge(name:String, age:Int):Int{
    println(name)
    println(age)
    return 1
}

fun multyInline(first:Int, second:Int):Int = first * second
fun divideInline(first:Int, second:Int) = (first/second).toDouble()


fun getSem(month:Int){

    when(month){
        in 1..6 -> println("1 Semestre")
        7,8,9,10,11,12 -> println("2 Semestre")
    }
}


fun result(value:Any){
    when(value){
        is Int -> println("Es Integer")
        is String -> println("Es String")
        is Boolean -> println("Es boolean")
        else -> println("Es de otro tipo")
    }
}

fun resultOp(value:Any):Any{
    var resultado =
    when(value){
        is Int -> value*value
        is String -> value + " " + value
        is Boolean -> !value
        else -> println("tipo desconocido")
    }
    return resultado
}



fun resultOp2(value:Any) = {
    var resultado =
        when (value) {
            is Int -> value * value
            is String -> value + " " + value
            is Boolean -> !value
            else -> println("tipo desconocido")
        }
}












