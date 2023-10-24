package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.simondice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var aleatorios= arrayListOf<Int>()
    var elecJugador= arrayListOf<Int>()
    var nivel = 1

    var timer = object: CountDownTimer((nivel * 2 * 800).toLong(), 800){
        override fun onTick(millisUntilFinished: Long) {
            binding.tvLevel.text= "seconds remaining: " + millisUntilFinished / 1000
        }

        override fun onFinish() {
            binding.tvLevel.text= "prueba"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var colores= listOf(binding.etRojo,binding.etYellow,binding.etVerde,binding.etBlue)
        binding.tvLevel.text="Nivel $nivel"
        binding.btnSiguiente.text="Iniciar"


        binding.btnSiguiente.setOnClickListener {
            timer.start()
        }

        binding.btnReiniciar.setOnClickListener {

        }

        for (color in colores){
            color.setOnClickListener {

            }
        }
    }

}