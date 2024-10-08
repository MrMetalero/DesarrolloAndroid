package com.example.ud1_kotlin_menadaniel

fun main(){
    mutableList()
    inmutableList()

}

fun inmutableList() {
    val readOnlyList:List<String> = listOf("PMDM", "ADA", "DIN", "SGE", "INT", "EIE", "PSP","PDAM")
    println(readOnlyList.toString())

    //Print foreach con .toString
    for (asignatura in readOnlyList){
        println(readOnlyList.toString())
    }
    //Print foreach clasico
    for (asignatura in readOnlyList){
        println(asignatura)
    }


    readOnlyList.forEach{
        println(it)
    }

    readOnlyList.forEach{  asignatura ->
        println(asignatura)
    }

    //Filtrado de la lista y meterlo en una variable
    var listaFiltrada = readOnlyList.filter {
    it.contains("p", true)
    }
    println(listaFiltrada)

    //Filtrado de la lista (PSP) y meterlo en una variable
    var listaFiltrada2 = readOnlyList.filter {
        it.contains("PSP",true)
    }
    println(listaFiltrada2)


}

fun mutableList() {
    val weekDays:MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    weekDays.add("NewDay")
    weekDays.add(2,"Second Monday")

    println("Lista Mutable \n $weekDays")
    //remove por contenido
    weekDays.remove("Wednesday")
    //remove por posicion
    weekDays.removeAt(3)

    println("Lista Mutable Modificada \n $weekDays")
}


