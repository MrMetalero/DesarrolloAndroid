package com.apli.appsaludo

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
        val nameCajaTexto:String = etName.text.toString()

        //LOGCAT Y TOAST
        btnHello.setOnClickListener{
            //Log.i("Test","Boton pulsado")

            Toast.makeText(this,"Hola $nameCajaTexto Que tal?",Toast.LENGTH_LONG).show()
        }




    }
}