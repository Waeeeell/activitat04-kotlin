package com.example.activitat04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean= true

    private var isFemaleSelected: Boolean = false

    private var alturaActual:Int = 120
    private var PesoActual: Int = 60
    private var edadActual: Int = 18
    private lateinit var male: CardView
    private lateinit var female: CardView
    private lateinit var numAlt: TextView
    private lateinit var rsAlt: RangeSlider

    private lateinit var pesoMas: FloatingActionButton
    private lateinit var pesoMenos: FloatingActionButton
    private lateinit var edadMas : FloatingActionButton
    private lateinit var edadMenos: FloatingActionButton
    private lateinit var numPeso: TextView
    private lateinit var numEdad: TextView
    private lateinit var botonCalcular: Button

    companion object{
        const val IMC_KEY = "ImcResultado"
    }


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
        pesoMas = findViewById<FloatingActionButton>(R.id.pesoMas)
        pesoMenos = findViewById<FloatingActionButton>(R.id.pesoMenos)
        edadMas = findViewById<FloatingActionButton>(R.id.edadMas)
        edadMenos = findViewById<FloatingActionButton>(R.id.edadMenos)
        numPeso = findViewById<TextView>(R.id.numPeso)
        numEdad = findViewById<TextView>(R.id.numEdad)
        botonCalcular = findViewById<Button>(R.id.botonCalcular)

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
            alturaActual= df.format(value).toInt()
            numAlt.text = "$alturaActual cm"
        }
        pesoMas.setOnClickListener {
            PesoActual += 1
            setPeso()
        }
        pesoMenos.setOnClickListener {
            PesoActual -= 1
            setPeso()
        }

        edadMas.setOnClickListener {
            edadActual += 1
            setAltura()
        }

        edadMenos.setOnClickListener {
            edadActual -= 1;
            setAltura()
        }

        botonCalcular.setOnClickListener {
            val resultado = calcularIMC()
            navegarAlResultado(resultado)
        }
    }

    private fun navegarAlResultado(resultado: Double){
        val intent = Intent(this, ResultadoIMCPantalla2::class.java)
        intent.putExtra("ImcResultado", resultado)
        startActivity(intent)

    }
    private fun calcularIMC(): Double{
        val df = DecimalFormat("#.##")
        val imc = PesoActual/(alturaActual.toDouble() / 100 * alturaActual.toDouble() / 100)
        return df.format(imc).toDouble()

    }

    private fun setPeso(){
        numPeso.text = PesoActual.toString()
    }

    private fun setAltura(){
       numEdad. text = edadActual.toString()
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
        setPeso()
        setAltura()
    }
}
