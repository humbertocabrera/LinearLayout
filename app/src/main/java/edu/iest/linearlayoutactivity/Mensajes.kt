package edu.iest.linearlayoutactivity
import android.content.Context
import android.widget.Toast

class Mensajes(var mensaje: String, var context: Context) {

    fun mostrarToast(){
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }

}