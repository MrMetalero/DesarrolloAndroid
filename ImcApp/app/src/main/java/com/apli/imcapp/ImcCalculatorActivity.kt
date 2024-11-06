package com.apli.imcapp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var viewSliderComponent: RangeSlider
    private lateinit var viewAlturaText: TextView
    private lateinit var viewPlusPeso: FloatingActionButton
    private lateinit var viewMinusPeso: FloatingActionButton
    private lateinit var viewPlusEdad: FloatingActionButton
    private lateinit var viewMinusEdad: FloatingActionButton
    private lateinit var viewPesoText: TextView
    private lateinit var viewEdadText: TextView
    private lateinit var viewCalcularImc: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()

    }


    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        viewSliderComponent = findViewById(R.id.rsHeight)
        viewAlturaText = findViewById(R.id.tvHeight)

        // Para la seccion de botones de edad
        viewPesoText = findViewById(R.id.tvPeso)
        viewEdadText = findViewById(R.id.tvEdad)

        viewMinusEdad = findViewById(R.id.minusEdad)
        viewPlusEdad = findViewById(R.id.plusEdad)

        viewMinusPeso = findViewById(R.id.minusPeso)
        viewPlusPeso = findViewById(R.id.plusPeso)

        viewCalcularImc = findViewById(R.id.botonCalculo)






    }



    var isComponentSelectedMale = false
    var isComponentSelectedFemale = false



    private fun initListeners(){



        viewMale.setOnClickListener {

            isComponentSelectedMale = true
            isComponentSelectedFemale = false
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            isComponentSelectedFemale = true
            isComponentSelectedMale= false
            setGenderColor()
        }

        viewSliderComponent.addOnChangeListener{_,value,_ ->
            //viewAlturaText.text = value.toString()
            viewAlturaText.text = DecimalFormat("#.##").format(value) + " cm"


        }



        //Onclick para peso
        viewMinusPeso.setOnClickListener {

            if (viewPesoText.text.toString().toInt() > 0) {
                viewPesoText.text = (viewPesoText.text.toString().toInt() - 1).toString()
            }else{
                viewPesoText.text = viewPesoText.text
            }

        }

        viewPlusPeso.setOnClickListener {

            if (viewPesoText.text.toString().toInt() >= 0) {
                viewPesoText.text = (viewPesoText.text.toString().toInt() + 1).toString()
            }else{
                viewPesoText.text = viewPesoText.text

            }


        }



        //Onclick para edad
        viewMinusEdad.setOnClickListener {

            if (viewEdadText.text.toString().toInt() > 0){
                viewEdadText.text =   (viewEdadText.text.toString().toInt()  -1).toString()

            }else{
                viewEdadText.text = viewEdadText.text

            }


        }

        viewPlusEdad.setOnClickListener {

            if (viewEdadText.text.toString().toInt() >= 0) {
                viewEdadText.text = (viewEdadText.text.toString().toInt() + 1).toString()
            }else{
                viewEdadText.text = viewEdadText.text

            }


        }



        viewCalcularImc.setOnClickListener{
            navigateToResult(calculateIMC())

        }




    }

    private fun navigateToResult(dobleRecibido:Double) {
        var dobleResultado = dobleRecibido
        val intentImcResult = Intent(this, ImcResultActivity::class.java)
        startActivity(intentImcResult)
    }


    private fun calculateIMC():Double{

        val edad: Int = viewEdadText.text.toString().toInt()
        val peso:Int = viewPesoText.text.toString().toInt()
        val altura:Int = viewAlturaText.text.toString().toInt()


        return (peso/(altura*altura)).toDouble()
    }


    private fun getBackgroundColor(isComponentSelected:Boolean):Int{
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp
        } else {

            R.color.bg_comp_sel
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isComponentSelectedMale))
        viewFemale.setCardBackgroundColor(getBackgroundColor(!isComponentSelectedMale))
    }





}