package com.example.activitat04

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoIMCPantalla2 : AppCompatActivity() {

    private lateinit var informativo: TextView
    private lateinit var resultado2: TextView
    private lateinit var  descripcionSituacion: TextView

    private fun initComponent(){
        informativo = findViewById<TextView>(R.id.informativo)
        resultado2 = findViewById<TextView>(R.id.resultado2)
        descripcionSituacion = findViewById<TextView>(R.id.descripcionSituacion)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_imcpantalla2)

        val resultado: Double = intent.extras?.getDouble("IMC_KEY") ?: -1.0
        initComponent()
        initUI(resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun initUI(resultado: Double) {
        when(resultado){
            in 0.00..18.50 -> { //bajo peso
                informativo
                resultado2
                descripcionSituacion
            }
            in 18.51..24.99 -> { //peso normal
                informativo
                resultado2
                descripcionSituacion
            }
            in 25.00..29.99 -> { //sobrepeso
                informativo
                resultado2
                descripcionSituacion
            }
            in 30.00..99.00 -> { //obesidad
                informativo
                resultado2
                descripcionSituacion
            }
            else -> { //error
                informativo.text="Error"
                resultado2.text="Error"
                descripcionSituacion.text="Error"
            }
        }
    }
}