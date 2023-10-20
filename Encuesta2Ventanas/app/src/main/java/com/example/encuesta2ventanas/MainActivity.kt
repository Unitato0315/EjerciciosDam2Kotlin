package com.example.encuesta2ventanas

import Persona.AlmacenPersonas
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.encuesta2ventanas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            var valido = validar()
            if (valido){
                irVentana()
                borrado()
            }
        }

        binding.btnBorrar.setOnClickListener {
            borrado()
        }
    }

    fun irVentana(){
        var sIntent: Intent = Intent(this, ConfirmationActivity::class.java)
        sIntent.putExtra("nombre",binding.edtNombre.text.toString())
        sIntent.putExtra("apellido",binding.edtApellido.text.toString())
        sIntent.putExtra("dni",binding.edtDNI.text.toString())
        sIntent.putExtra("email",binding.edtEmail.text.toString())
        sIntent.putExtra("cont",binding.edtCont.text.toString())
        startActivity(sIntent)
    }
    fun validar(): Boolean{
        var valido = true
        var nombre = binding.edtNombre.text.toString()
        var apellido = binding.edtApellido.text.toString()
        var email = binding.edtEmail.text.toString()
        var dni = binding.edtDNI.text.toString()
        var contrasena = binding.edtCont.text.toString()
        var confirmar = binding.edtConfir.text.toString()

        if (nombre.isBlank() || apellido.isBlank() || email.isBlank() || dni.isBlank() || contrasena.isBlank() || confirmar.isBlank()){
            valido = false
            Toast.makeText(this,"No pueden quedar registros en blanco", Toast.LENGTH_SHORT).show()
        }else if(contrasena.length<=6){
            valido = false
            Toast.makeText(this,"La contraseña tiene que tener mas de 6 caracteres", Toast.LENGTH_SHORT).show()
        }else if(contrasena != confirmar){
            valido = false
            Toast.makeText(this,"No coinciden las contraseñas", Toast.LENGTH_SHORT).show()
        }

        for (p in AlmacenPersonas.personas){
            if (dni == p.dni){
                Toast.makeText(this,"Este Usuario ya esta registrado", Toast.LENGTH_SHORT).show()
                valido=false
            }
        }

        return valido
    }
    fun borrado(){
        binding.edtNombre.setText("")
        binding.edtApellido.setText("")
        binding.edtDNI.setText("")
        binding.edtEmail.setText("")
        binding.edtCont.setText("")
        binding.edtConfir.setText("")
    }
}