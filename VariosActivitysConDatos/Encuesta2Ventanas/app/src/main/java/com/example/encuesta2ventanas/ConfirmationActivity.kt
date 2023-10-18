package com.example.encuesta2ventanas

import Persona.AlmacenPersonas
import Persona.Persona
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.encuesta2ventanas.databinding.ActivityConfirmationBinding
import com.example.encuesta2ventanas.databinding.ActivityMainBinding

class ConfirmationActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfirmationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nombre = intent.getStringExtra("nombre")
        var apellido = intent.getStringExtra("apellido")
        var dni = intent.getStringExtra("dni")
        var email = intent.getStringExtra("email")
        var contrasena = intent.getStringExtra("contrasena")
        var persona = Persona(nombre,apellido,dni,email,contrasena)
        binding.edtNombre2.setText(nombre)
        binding.edtApellido2.setText(apellido)
        binding.edtDNI2.setText(dni)
        binding.edtEmail2.setText(email)
        binding.edtCont2.setText(contrasena)

        AlmacenPersonas.anaiadirPersona(persona)

        var cadena: String = ""
        var i = 1
        for(p in AlmacenPersonas.personas){
            cadena+= i.toString()+" "+p.nombre+" "+p.Apellido+" "+p.dni+" "+p.email+" "+p.contraseña+"\n"
            i++
            binding.editTextTextMultiLine.setText(cadena)
        }

        binding.btnVolver.setOnClickListener{
            finish()
        }
    }
}