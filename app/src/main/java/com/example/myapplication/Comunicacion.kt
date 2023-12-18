package com.example.myapplication

// se debe crear una iterfaz que permnite la comunicacion de la main con cada fragment
// la comunicacion es main-> fragment   fragment -> main->grament
interface Comunicacion {
    // va a ser la funcion que sobrescribir para mandar los datos
    fun enviarDatos(datosEnviados :String)
}