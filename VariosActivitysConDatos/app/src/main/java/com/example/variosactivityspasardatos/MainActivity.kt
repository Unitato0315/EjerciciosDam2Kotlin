package com.example.variosactivityspasardatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.variosactivityspasardatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener {
            irVentana()
        }
    }

    private fun irVentana() {
        var sIntent: Intent = Intent(this, Ventana2::class.java)
        sIntent.putExtra("nombre",binding.cajaNombre.text.toString())
        sIntent.putExtra("edad",binding.cajaEdad.text.toString())
        startActivity(sIntent)
    }
}