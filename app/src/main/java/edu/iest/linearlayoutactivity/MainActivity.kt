package edu.iest.linearlayoutactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var etNumeroPrimero : EditText? = null
    private var etNumeroSegundo : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarVistas()
        asignarEventos()
    }

    private fun inicializarVistas(){
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etNumeroSegundo)
    }

    private fun asignarEventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //Aquí entrara los click de las vistas
        //Snackbar y Toast hacen lo mismo, pero visualmente se ve diferente
        val numeroUno = etNumeroPrimero?.text.toString().toFloatOrNull()
        val numeroDos = etNumeroSegundo?.text.toString().toFloatOrNull()

        if (numeroUno == null){
            return
        }
        if (numeroDos == null){
            return
        }

        val aritmetica = Aritmetica()

        when(p0?.id){
            R.id.bnSuma -> {
                val suma = aritmetica.suma(numeroUno,numeroDos)
                val mensaje = Mensajes("La sumatoria fue $suma", this)
            }

            R.id.bnResta -> {
                val resta = aritmetica.resta(numeroUno,numeroDos)
                val mensaje = Mensajes("El resultado fue $resta", this)
            }
        }

    }
}