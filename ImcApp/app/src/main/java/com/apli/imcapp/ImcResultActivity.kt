package com.apli.imcapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.properties.Delegates

class ImcResultActivity : AppCompatActivity() {
    private var imc:Double = 0.0
    private lateinit var textTitlePeso: TextView
    private lateinit var textResultadoValor: TextView
    private lateinit var textDescripcionPeso: TextView
    private lateinit var buttonRecalcular: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents(){

        textTitlePeso = findViewById(R.id.titleActivity2)
        textResultadoValor = findViewById(R.id.resultadoNumero)
        textDescripcionPeso = findViewById(R.id.descripcionResultado)
        buttonRecalcular = findViewById(R.id.botonRecalcular)

        textResultadoValor.text = imc.toString()

    }


    private fun initListeners(){
            buttonRecalcular.setOnClickListener{
                finish()

            }


    }

    private fun initUI(){
        recibirResultado()
        when {
            imc < 18.5 -> {
                // Underweight
                textTitlePeso.text = getString(R.string.inferiorPeso)
                textDescripcionPeso.text = getString(R.string.inferiorPesoDescripcion)
            }
            imc in 18.5..24.9 -> {
                // Normal weight
                textTitlePeso.text = getString(R.string.normalpeso)
                textDescripcionPeso.text = getString(R.string.normalDescripcion)
            }
            imc in 25.0..29.9 -> {
                // Overweight
                textTitlePeso.text = getString(R.string.sobrepeso)
                textDescripcionPeso.text = getString(R.string.sobrepesoDescripcion)
            }
            imc in 30.0..34.9 -> {
                // Obesity I
                textTitlePeso.text = getString(R.string.obesidad1)
                textDescripcionPeso.text = getString(R.string.obesidad1Descripcion)
            }
            imc in 35.0..39.9 -> {
                // Obesity II
                textTitlePeso.text = getString(R.string.obesidad2)
                textDescripcionPeso.text = getString(R.string.obesidad2Descripcion)
            }
            imc >= 40.0 -> {
                // Extreme Obesity III
                textTitlePeso.text = getString(R.string.obesidad3)
                textDescripcionPeso.text = getString(R.string.obesidad3Descripcion)
            }
        }

    }


    private fun recibirResultado(){
        imc = String.format("%.2f", intent.extras?.getDouble("RESULTADOIMC") ?: -1.0).toDouble()
        textResultadoValor.text = imc.toString()
    }








}