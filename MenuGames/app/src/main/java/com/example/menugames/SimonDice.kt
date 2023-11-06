package com.example.menugames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.menugames.databinding.ActivitySimonDiceBinding

class SimonDice : AppCompatActivity() {
    lateinit var binding: ActivitySimonDiceBinding
    var patron = mutableListOf<Int>()
    var nivel = 0
    var colores = mutableListOf<TextView>()
    var cont = 0
    var cont2 = 0
    var contRespuestas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimonDiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarSimon.title = "Jugador "+intent.getStringExtra("nombre")

        setSupportActionBar(binding.toolbarSimon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarSimon.setNavigationOnClickListener {
            finish()
        }

        colores.addAll(listOf(binding.etRojo,binding.etVerde,binding.etYellow,binding.etBlue))
        binding.tvLevel.visibility= View.INVISIBLE
        binding.tvResul.visibility= View.INVISIBLE
        binding.btnReiniciar.isEnabled=false
        binding.btnSiguiente.text="Iniciar"
        for (color in colores){
            color.isEnabled = false
        }

        binding.btnSiguiente.setOnClickListener {
            this.nivel++
            patron.add((1..4).random())
            contRespuestas=0
            iniciarPatron()
            binding.tvLevel.visibility= View.VISIBLE
            binding.tvResul.visibility= View.INVISIBLE
            binding.tvLevel.text="Nivel $nivel"
        }

        binding.btnReiniciar.setOnClickListener {
            nivel = 0
            contRespuestas=0
            binding.tvLevel.visibility= View.INVISIBLE
            binding.btnSiguiente.text="Iniciar"
            binding.btnSiguiente.isEnabled=true
            patron.clear()
            for (color in colores){
                color.isEnabled = false
            }
        }

        for (color in colores){
            color.setOnClickListener {
                comprobarEleccion(color)
            }
        }
    }

    fun comprobarEleccion(color: TextView){
        binding.tvResul.visibility= View.INVISIBLE
        if(patron[contRespuestas].compareTo(color.contentDescription.toString().toInt())==0){
            for (color in colores){
                color.isEnabled = false
            }
            var timer = object: CountDownTimer((2 * 800).toLong(), 800){
                override fun onTick(millisUntilFinished: Long) {
                    if(cont%2 == 0){

                        when(patron[contRespuestas]){
                            1 -> colores[0].setBackgroundColor(getColor(R.color.red))
                            2 -> colores[1].setBackgroundColor(getColor(R.color.green))
                            3 -> colores[2].setBackgroundColor(getColor(R.color.yellow))
                            4 -> colores[3].setBackgroundColor(getColor(R.color.blue))
                        }
                    }else{
                        when(patron[contRespuestas]){
                            1 -> colores[0].setBackgroundColor(getColor(R.color.redPalid))
                            2 -> colores[1].setBackgroundColor(getColor(R.color.greenPalid))
                            3 -> colores[2].setBackgroundColor(getColor(R.color.yellowPalid))
                            4 -> colores[3].setBackgroundColor(getColor(R.color.bluePalid))
                        }
                    }
                    cont++
                }

                override fun onFinish() {
                    cont = 0
                    for (color in colores){
                        color.isEnabled = true
                    }
                    contRespuestas++;
                    if (contRespuestas == patron.size){
                        for (color in colores){
                            color.isEnabled = false
                        }
                        binding.tvResul.visibility= View.VISIBLE
                        binding.tvResul.text= "Has acertado puedes pasar al siguente nivel"
                        binding.btnSiguiente.isEnabled=true
                    }
                }
            }
            timer.start()

        }else{
            binding.tvResul.visibility= View.VISIBLE
            binding.tvResul.text= "Te has equivocado vuelve a intentarlo"
            contRespuestas=0
            iniciarPatron()
        }
    }
    fun iniciarPatron(){
        for (color in colores){
            color.isEnabled = false
        }
        binding.btnReiniciar.isEnabled=false
        binding.btnSiguiente.isEnabled=false

        var timer = object: CountDownTimer((nivel * 2 * 800).toLong(), 800){
            override fun onTick(millisUntilFinished: Long) {
                if(cont%2 == 0){
                    when(patron[cont2]){
                        1 -> colores[0].setBackgroundColor(getColor(R.color.red))
                        2 -> colores[1].setBackgroundColor(getColor(R.color.green))
                        3 -> colores[2].setBackgroundColor(getColor(R.color.yellow))
                        4 -> colores[3].setBackgroundColor(getColor(R.color.blue))
                    }
                }else{
                    when(patron[cont2]){
                        1 -> colores[0].setBackgroundColor(getColor(R.color.redPalid))
                        2 -> colores[1].setBackgroundColor(getColor(R.color.greenPalid))
                        3 -> colores[2].setBackgroundColor(getColor(R.color.yellowPalid))
                        4 -> colores[3].setBackgroundColor(getColor(R.color.bluePalid))
                    }
                    cont2++
                }
                cont++
            }

            override fun onFinish() {
                cont = 0
                cont2 = 0
                for (color in colores){
                    color.isEnabled = true
                }
                binding.btnReiniciar.isEnabled=true
            }
        }
        timer.start()
    }
}