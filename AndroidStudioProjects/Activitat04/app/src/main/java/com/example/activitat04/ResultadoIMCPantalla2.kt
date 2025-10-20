package com.example.activitat04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoIMCPantalla2 : AppCompatActivity() {

    private lateinit var informativo: TextView
    private lateinit var resultado2: TextView
    private lateinit var  descripcionSituacion: TextView
    private lateinit var Recalcular: Button

    private fun initComponent(){
        informativo = findViewById<TextView>(R.id.informativo)
        resultado2 = findViewById<TextView>(R.id.resultado2)
        descripcionSituacion = findViewById<TextView>(R.id.descripcionSituacion)
        Recalcular = findViewById(R.id.botonReCalcular)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_imcpantalla2)

        val resultado: Double = intent.extras?.getDouble("ImcResultado") ?: -1.0
        initComponent()
        initUI(resultado)
        listener()
    }

    private fun initUI(resultado: Double) {
        resultado2.text= resultado.toString()
        when(resultado){
            in 0.00..18.50 -> { //bajo peso
                informativo.text = getString(R.string.imc_bajo)
                informativo.setTextColor(getColor(R.color.Amarillo))
                descripcionSituacion.text = getString(R.string.descripcion_peso_bajo)
                descripcionSituacion.setTextColor(getColor(R.color.Amarillo))
            }
            in 18.51..24.99 -> { //peso normal
                informativo.text = getString(R.string.imc_normal)
                informativo.setTextColor(getColor(R.color.verdeBien))
                descripcionSituacion.text = getString(R.string.descripcion_peso_normal)
                descripcionSituacion.setTextColor(getColor(R.color.verdeBien))
            }
            in 25.00..29.99 -> { //sobrepeso
                informativo.text = getString(R.string.sobrepeso)
                informativo.setTextColor(getColor(R.color.Naranja))
                descripcionSituacion.text = getString(R.string.Descripcion_sobrepeso)
                descripcionSituacion.setTextColor(getColor(R.color.Naranja))

            }
            in 30.00..99.00 -> { //obesidad
                informativo.text = getString(R.string.obesidad)
                informativo.setTextColor(getColor(R.color.rojoObesidad))
                descripcionSituacion.text = getString(R.string.Descripcion_obesidad)
                descripcionSituacion.setTextColor(getColor(R.color.rojoObesidad))
            }
            else -> { //error
                informativo.text= getString(R.string.error)
                resultado2.text= getString(R.string.error)
                descripcionSituacion.text= getString(R.string.error)
            }
        }
    }

    private fun listener(){
        Recalcular.setOnClickListener{
            recalcula()
        }
    }

    private fun recalcula(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}