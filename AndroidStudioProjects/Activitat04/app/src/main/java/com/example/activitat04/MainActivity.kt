package com.example.activitat04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean= true

    private var isFemaleSelected: Boolean = false
    private lateinit var male: CardView
    private lateinit var female: CardView


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
