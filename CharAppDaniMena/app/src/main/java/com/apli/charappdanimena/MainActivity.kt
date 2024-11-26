package com.apli.charappdanimena

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var yuantiCard : CardView
    lateinit var  orcCard : CardView
    lateinit var  tieflingCard : CardView
    lateinit var powerRangeSlider: RangeSlider
    lateinit var textPowerNumber : TextView
    lateinit var  fabCambioActividad : FloatingActionButton
    lateinit var  textNameCharacter : EditText

    companion object {
        const val NAME_CHARACTER_KEY = "RESULT"
        const val RACE_CHARACTER_KEY = "RESULT"
        const val POWER_CHARACTER_KEY = "RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        setListeners()

    }


    fun initComponents(){
        yuantiCard = findViewById(R.id.yuantiCard)
        orcCard = findViewById(R.id.orcCard)
        tieflingCard = findViewById(R.id.tieflingCard)
        powerRangeSlider = findViewById(R.id.rangePower)
        textPowerNumber = findViewById(R.id.powerNumber)
        fabCambioActividad = findViewById(R.id.fabResultado)
        textNameCharacter = findViewById(R.id.editableName)

    }

    var selectedCard: String = "None"

    fun setListeners() {
        textPowerNumber.text = getString(R.string.defaultPower) // Por defecto si no toca el rangeSlider
        //ON CHANGE SLIDER
        powerRangeSlider.addOnChangeListener { _, value, _ ->
            textPowerNumber.text = DecimalFormat("###").format(value)
        }


        // FAB ONCLICK

        fabCambioActividad.setOnClickListener{

            if (selectedCard == "None"){
                Toast.makeText(this,"Debes seleccionar una raza para crear el personaje",Toast.LENGTH_LONG).show()
            }else{


                val intent = Intent(this,ResultCharacterActivity::class.java)
                    .putExtra("NAME_CHARACTER_KEY",textNameCharacter.text.toString())
                    .putExtra("RACE_CHARACTER_KEY",selectedCard)
                    .putExtra("POWER_CHARACTER_KEY",textPowerNumber.text)
                startActivity(intent)

            }



        }




        //ONCLICK CARDVIEWS

        yuantiCard.setOnClickListener{
            yuantiCard.setCardBackgroundColor(getResources().getColor(R.color.selected))
            orcCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            tieflingCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            selectedCard = "yuanti"
        }

        orcCard.setOnClickListener{
            orcCard.setCardBackgroundColor(getResources().getColor(R.color.selected))
            yuantiCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            tieflingCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            selectedCard = "orc"
        }

        tieflingCard.setOnClickListener{
            tieflingCard.setCardBackgroundColor(getResources().getColor(R.color.selected))
            orcCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            yuantiCard.setCardBackgroundColor(getResources().getColor(R.color.deselected))
            selectedCard = "tiefling"
        }



    }















}