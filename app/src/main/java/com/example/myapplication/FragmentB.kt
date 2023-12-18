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

class FragmentB: Fragment() {

    private var elementoComunicador : Comunicacion? = null


    private var textoRecibido : String? = null

    private var textoEmitido: String? = null

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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vistaFragB = inflater.inflate(R.layout.fragment_b, container, false)

        val botonB = vistaFragB.findViewById<Button>(R.id.b_fragB)

        if (savedInstanceState!=null){
            // si hay guardado se deben recuperar los datos que se tengan y mostrarlos
            textoRecibido = savedInstanceState.getString("textoSalvado")

            vistaFragB. findViewById<TextView>(R.id.txtV_fragB).text= textoRecibido
        }

        return vistaFragB
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun actualizarTexto (datos : String){
        textoEmitido = datos

        view?.findViewById<EditText>(R.id.eTxt_fragA)?.text//?????????
    }
}