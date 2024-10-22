package com.apli.appsaludo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHello:AppCompatButton = findViewById(R.id.btnHello)
        val etName:AppCompatEditText =
            findViewById(R.id.cajatexto)


        //LOGCAT, TOAST, CERRAR ACTIVIDAD O SET NULL AL TEXTVIEW, CAMBIAR ACTIVIDAD
        btnHello.setOnClickListener{
            //Log.i("Test","Boton pulsado")
            val nameCajaTexto:String = etName.text.toString() //Esto tiene que estar aqui o no pillara el texto
            //Toast.makeText(this,"Hola $nameCajaTexto Que tal?",Toast.LENGTH_LONG).show()

           /* if (nameCajaTexto.isNotEmpty()) {
                Snackbar.make(btnHello, "Hola $nameCajaTexto!", Snackbar.LENGTH_SHORT)
                    .setAnchorView(btnHello)
                    .setAction("CLOSE") { etName.setText(null) }
                    .show()
            }*/

            // INICIA A SEGUNDA ACTIVIDAD
        val intentGA = Intent(this, SecondActivity::class.java)
            intentGA.putExtra("EXTRA_NAME", nameCajaTexto)
            startActivity(intentGA)

        }




    }
}