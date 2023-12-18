package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


// se crea una clase que hereda de fragment-- cad fragment debe definirse con un espaio propio en el layout de la main que va a ser el espacio que va a ocupar.
class FramentA: Fragment() {

    // se instacia un objeto del tipo comunicacion que es el que va a encargarse de hacer el movimiento de datos-- comunicacion se implementa en la main
    private var elementoComunicador : Comunicacion? = null

    // se guardara el texto que se llega del otro fragment
    private var textoRecibido : String? = null

    private var textoEmitido: String? = null

    // EN EL CASI 100% DE LOS CASOS SE PONE PRIMERO EL ONATTACH()
    // la funcion onAttach vincula el fragment a la vista principal que lo va a llamar
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // se le pasa al elementoComunicador el contexto de la actividad como un objeto del tipo comunicacion
        elementoComunicador = context as? Comunicacion
    }

    // Funcion que va a encargase de comprobar si hay un entorno/ conrexto/ estado de la apliacion guardado
    // es un metodo que se llama solo cuando se va a destuir un fragmento y sirve para guardar los cambios que haya en la pantalla como datos metidos y demas
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // se guarda el estado de fragment, en este caso el texto que se desea enviar al otro
        // "textoSalvado" representa la pk por la que referirse a ese mensaje
        outState.putString("textoSalvado", textoEmitido)
    }

    override fun onCreateView(
        inflater: LayoutInflater,// infla la vista del fragment
        container: ViewGroup?,//
        savedInstanceState: Bundle? // el bundle es quien va a guardar el estado de la app para cuando se ejecute una recarga de la vista como cuandfo se gira
    ): View? {// la vista que se va a devoler va a ser la asociada al fragment

        val vistaFragA = inflater.inflate(R.layout.fragment_a, container, false)
        val botonA = vistaFragA.findViewById<Button>(R.id.b_enviarfragA) // OJO- importante asociar cada boton correspondiente al fragment

        // comprobar si hay algun estado guardado antes de crear la vista del fragment
        if (savedInstanceState!=null){
            // si hay guardado se deben recuperar los datos que se tengan y mostrarlos
            textoRecibido = savedInstanceState.getString("textoSalvado")

            vistaFragA. findViewById<TextView>(R.id.txtV_fragA).text= textoRecibido
        }

        return vistaFragA
    }

    // funcion que determina la funcionalidad del fragment una vez se ha cargado
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun actualizarTexto (datos : String){
        textoEmitido = datos

        view?.findViewById<EditText>(R.id.eTxt_fragA)?.text//??????????
    }
}