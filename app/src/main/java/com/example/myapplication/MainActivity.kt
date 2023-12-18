package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// se implementa la clase comunicacion para que la actividad principal haga de interlocutor entre los fragments
class MainActivity : AppCompatActivity(), Comunicacion {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // se añaden los fragments-- se hacen por separado CASI SIEMPRE
        // se comprueba si no se ha guardado ningun estado previo antes de lanzar el fragment
        if (savedInstanceState == null){
            /*
                 val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            val fragment = EjemploFragment()
//            fragmentTransaction.add(R.id.fragment_container, fragment)
//            fragmentTransaction.commit()


             */
            // es lo mismo que lo de arriab pero condensado
            /* explicacion:
            - primero se establece el supportframgetn manager que va gestionar al transcicion de la main al fragment
            - a la transaccion se añade la referencia al contenedor del fragment que sta en el layout de la main y un objeto de la clase fragment
             en este caso se pasa de la case A ya que se a intanciar ese
             - finalmente se hace un comit--SIEMPRE

             */
            supportFragmentManager.beginTransaction().add(R.id.fragmentA, FramentA()).commit()
        }
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentB,FragmentB()).commit()
        }
    }


    override fun enviarDatos(datosEnviados: String) {
        // se desarrolla como se va a enviar los datos
    }
}