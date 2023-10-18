package com.example.encuesta

import Encuesta.Encuesta
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var ecuestados: ArrayList<Encuesta> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        var horas: String = "0"

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sbHoras.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean){
                var progreso = binding.sbHoras.progress
                binding.tvNumHoras.text=progreso.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar){
                var progreso = binding.sbHoras.progress
                binding.tvNumHoras.text=progreso.toString()
            }
            override fun onStopTrackingTouch(p0: SeekBar){
                var progreso = binding.sbHoras.progress
                horas = progreso.toString()
                binding.tvNumHoras.text=progreso.toString()
            }

        })
        binding.btnValidar.setOnClickListener {
            botonValidar(horas)
        }

        binding.btnReiniciar.setOnClickListener {
            ecuestados = ArrayList()
            binding.editTextTextMultiLine.setText("")
            Toast.makeText(this, "Reiniciado", Toast.LENGTH_SHORT).show()
        }

        binding.btnCuentas.setOnClickListener {
            Toast.makeText(this, ecuestados.size.toString()+" personas han sido encuestados", Toast.LENGTH_SHORT).show()
        }

        binding.btnResumen.setOnClickListener {
            var cadena: String = ""
            var i = 1
            for(e in ecuestados){
                cadena+= i.toString()+" "+ e.nombre+" "+ e.sistema+" "+e.grados+" "+e.horas+"\n"
                i++
                binding.editTextTextMultiLine.setText(cadena)
            }
        }
    }

    fun botonValidar(horas: String){
        var nombre: String
        var sistema: String? = null
        var especializacion = ArrayList<String>()
        if (binding.swAnonimo.isChecked){
            nombre = binding.swAnonimo.text.toString()
        }else{
            nombre = binding.etNombre.text.toString()
        }

        if (binding.rb1.isChecked){
            sistema = binding.rb1.text.toString()
        }
        else if (binding.rb2.isChecked){
            sistema = binding.rb2.text.toString()
        }
        else if (binding.rb3.isChecked){
            sistema = binding.rb3.text.toString()
        }

        if (binding.cbASIR.isChecked){
            especializacion.add(binding.cbASIR.text.toString())
        }
        if (binding.checkBox2.isChecked){
            especializacion.add(binding.checkBox2.text.toString())
        }
        if (binding.cbDAM.isChecked){
            especializacion.add(binding.cbDAM.text.toString())
        }

        if (especializacion.isNotEmpty() && nombre.isNotEmpty()){
            this.ecuestados.add(Encuesta(nombre,sistema,especializacion,horas))
        }else{
            Toast.makeText(this, "No has introducido todos los datos", Toast.LENGTH_SHORT).show()
        }
    }

}