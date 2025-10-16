package com.example.activitat04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean= true

    private var isFemaleSelected: Boolean = false
    private lateinit var male: CardView
    private lateinit var female: CardView
    private lateinit var numAlt: TextView
    private lateinit var rsAlt: RangeSlider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textSuperior = findViewById<TextView>(R.id.TextSuperior)

        initComponent()
        initListeners()
        initUI()

        }
    private fun initComponent(){
        male = findViewById(R.id.home)
        female = findViewById(R.id.dona)
        numAlt = findViewById<TextView>(R.id.numAlt)
        rsAlt = findViewById<RangeSlider>(R.id.rsAlt)
    }

    private fun initListeners(){
        male.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        female.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsAlt.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            numAlt.text = "$result cm"
        }
    }

    private fun setGenderColor(){
        male.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        female.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected =!isFemaleSelected
    }
    private fun getBackgroundColor(isSelectedComponent: Boolean): Int{
        val colorReference = if(isSelectedComponent){
            R.color.boton_seleccionat
    } else {
        R.color.boton
    }
    return ContextCompat.getColor(this,colorReference)
}
    private fun initUI(){
        setGenderColor()
    }
}
