package com.example.tresenraya


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.view.isVisible
import com.example.tresenraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var turno = (1..2).random()
    var eleccionesJuga1 = ArrayList<Int>()
    var eleccionesJuga2 = ArrayList<Int>()
    var botonesPulsados = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtTurno.text = "Turno del jugador $turno"
        val botones = arrayOf(binding.btn1,binding.btn2,binding.btn3,binding.btn4,binding.btn5,binding.btn6,binding.btn7,binding.btn8,binding.btn9)

        for (boton in botones){
            boton.setOnClickListener {
                clickBoton(boton)
            }
        }

        binding.btnOtra.setOnClickListener {
            botonesPulsados = 0
            eleccionesJuga1.clear()
            eleccionesJuga2.clear()
            for (boton in botones){
                boton.isEnabled=true
                boton.setImageResource(R.drawable.blanco)
            }
            binding.textView.visibility=View.INVISIBLE
            binding.btnOtra.isVisible=false
            turno = (1..2).random()
        }

    }
    fun clickBoton(boton : ImageButton){
        botonesPulsados += 1
        if(turno == 1){
            boton.setImageResource(R.drawable.x)
            turno = 2
            eleccionesJuga1.add(boton.contentDescription.toString().toInt())
            if (validar(eleccionesJuga1)){
                binding.textView.visibility=View.VISIBLE
                binding.textView.text="Gana el jugador 1"
                finPartida()
            }
        }else if(turno == 2){
            boton.setImageResource(R.drawable.o)
            eleccionesJuga2.add(boton.contentDescription.toString().toInt())
            turno = 1
            if (validar(eleccionesJuga2)){
                binding.textView.visibility=View.VISIBLE
                binding.textView.text="Gana el jugador 2"
                finPartida()
            }
        }else if(botonesPulsados == 9){
            empate()
        }
        binding.txtTurno.text = "Turno del jugador $turno"
        boton.isEnabled=false

    }

    fun validar(elecciones : ArrayList<Int>):Boolean{
        var ganador = false
        val map = mapOf(
            1 to listOf(1,2,3),
            2 to listOf(1,4,7),
            3 to listOf(1,5,9),
            4 to listOf(2,5,8),
            5 to listOf(3,5,7),
            6 to listOf(3,6,9),
            7 to listOf(4,5,6),
            8 to listOf(7,8,9),
        )

        for (value in map.values){
            if(elecciones.containsAll(value)){
                ganador = true
            }
        }

        return ganador
    }

    fun empate(){
        binding.btnOtra.visibility=View.VISIBLE
        binding.textView.visibility=View.VISIBLE
        binding.textView.text="Ha sido un empate"
    }
    fun finPartida(){
        val botones = arrayOf(binding.btn1,binding.btn2,binding.btn3,binding.btn4,binding.btn5,binding.btn6,binding.btn7,binding.btn8,binding.btn9)
        for (boton in botones){
            boton.isEnabled=false
        }
        binding.btnOtra.visibility=View.VISIBLE
    }
}