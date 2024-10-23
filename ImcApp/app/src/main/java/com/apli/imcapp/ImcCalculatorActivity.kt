package com.apli.imcapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView


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

    }



    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)

    }
    val cardViewMale = findViewById<CardView>(R.id.viewMale)
    val cardViewFemale = findViewById<CardView>(R.id.viewFemale)


    private fun initListeners(){

        var isComponentSelectedMale = false
        var isComponentSelectedFemale = false

        cardViewMale.setOnClickListener {

            cardViewMale.isActivated = true

            setGenderColor()
        }

        cardViewFemale.setOnClickListener {
            cardViewFemale.isActivated = true
            setGenderColor()
        }

    }

    private fun setGenderColor(){


    }





}