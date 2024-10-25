package com.apli.imcapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var cardViewMale: CardView
    private lateinit var cardViewFemale: CardView


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
        cardViewMale = viewMale // Direct reference since they're the same views
        cardViewFemale = viewFemale
    }



    var isComponentSelectedMale = false
    var isComponentSelectedFemale = false
    private fun initListeners(){



        cardViewMale.setOnClickListener {

            isComponentSelectedMale = true
            isComponentSelectedFemale = false
            setGenderColor()
        }

        cardViewFemale.setOnClickListener {
            isComponentSelectedFemale = true
            isComponentSelectedMale= false
            setGenderColor()
        }

    }



    private fun getBackgroundColor(isComponentSelected:Boolean):Int{
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel
        } else {
            R.color.bg_comp
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isComponentSelectedMale))
        viewFemale.setCardBackgroundColor(getBackgroundColor(!isComponentSelectedMale))
    }





}