package com.apli.charappdanimena

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultCharacterActivity : AppCompatActivity() {
    lateinit var textCharacterNameResult : TextView
    lateinit var  textCharacterPowerResult : TextView
    lateinit var  imageCharacterResult : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_character)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initUI()

    }



    fun initComponents(){
        textCharacterNameResult = findViewById(R.id.nameCharacterResult)
        textCharacterPowerResult = findViewById(R.id.powerCharacterResult)
        imageCharacterResult = findViewById(R.id.imageCharacterResult)

    }

    var resultImageString = "None"
    fun initUI(){

        textCharacterNameResult.text = intent.extras?.getString("NAME_CHARACTER_KEY").orEmpty()
        textCharacterPowerResult.text = intent.extras?.getString("POWER_CHARACTER_KEY").orEmpty()
        resultImageString = intent.extras?.getString("RACE_CHARACTER_KEY").orEmpty()

        when(resultImageString){

            "None" -> Toast.makeText(this,"ERROR, NO SE HA SELECCIONADO RAZA",Toast.LENGTH_LONG).show()

            "yuanti" -> imageCharacterResult.setImageResource(R.drawable.yuanti)

            "orc" -> imageCharacterResult.setImageResource(R.drawable.orc)

            "tiefling" -> imageCharacterResult.setImageResource(R.drawable.tiefling)



        }


    }



}