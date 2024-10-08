package com.example.ud1_kotlin_menadaniel

fun main(){

    val costePlato1 = 5

    println(costePlatos(costePlato1))

    var listaMesasLibres1:MutableList<Int> = mutableListOf(2,3,4,5,6)
    val numeroComensalesReserva1 = 5

    gestionarReservas(listaMesasLibres1,numeroComensalesReserva1)
    println(listaMesasLibres1.toString())

}

/*
*   He intentado usar expresion lambda pero algo no va bien
*
* fun costePlatos(precioPlato:Any){
    val stringResultadoPrecio = {
        when(precioPlato){
            5 -> "€"
            5.5..8.0 -> "€€"
            8.5 .. 15.0 -> "€€€"
            else -> {"Error"}
        }
    }
    return stringResultadoPrecio
}
* */

//DEBERIA CONTROLAR QUE NO ENTRAN  TIPOS QUE NO QUIERO EN ANY
// NECESITO MIRAR COMO PONER UN SOLO NUMERO PARA MAYOR O MENOR
// ANTES ME ESTABA DANDO EL RESULTADO CORRECTAMENTE. PERO AHORA HA DECIDIDO QUE NO? :/
fun costePlatos(precioPlato:Any):String{
    var stringResultadoPrecio:String


    stringResultadoPrecio = when(precioPlato){
        0.0..5.0 -> "€"
        5.5..8.0 -> "€€"
        8.5 .. 15.0 -> "€€€"
        15.5 .. 21.5 -> "€€€€"
        22.0 .. 999999999.0  -> "€€€€"
        else -> "Error"
    }


    return stringResultadoPrecio
}


fun gestionarReservas(listaMesasLibres:MutableList<Int>,comensalesReserva:Int):Boolean{
     var mesaEncontrada:Boolean = false
    for (mesa in listaMesasLibres){ // Se itera sobre las mesas
        if(mesa == comensalesReserva) { //Si se encuentra una mesa con plazas se reserva
            mesaEncontrada = true
            listaMesasLibres.removeAt(listaMesasLibres.indexOf(mesa)) //Se hace la reserva en it

        }
    }

    //LA FUNCION HACE SU TRABAJO PERO ES CUTRE Y PUEDE DAR ERRORES CON VARIAS MESAS
    //CON LA MISMA CANTIDAD DE ASIENTOS LOS BORRARA TODOS



    return mesaEncontrada
}

class reserva{

    var nombreReserva:String = "hey"


}

fun mostrarReserva(nombreReserva:String,horaReserva:String,fechaReserva:Array<Any>,reservaConfirmada:Boolean){
    if (reservaConfirmada == true){
        println(nombreReserva)
        println(horaReserva)
        println(fechaReserva.toString())

    }else{
        println("La reserva escogida no tiene disponibilidad")
    }
}


//PROCESAR RESERVA REQUIERE QUE UTILICE ? PARA DAR PASO A NULLABILIDAD





