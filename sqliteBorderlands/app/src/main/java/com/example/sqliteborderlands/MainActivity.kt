package com.example.sqliteborderlands

import Auxiliar.Conexion
import Modelo.Almacen
import Modelo.Arma
import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqliteborderlands.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fabricante: String
    lateinit var tipo: String
    lateinit var adapterFabri: ArrayAdapter<String>
    lateinit var adapterTipo: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnVerLista.setOnClickListener {
            Almacen.armas = Conexion.obtenerArmas(this)
            var inte = Intent(this, VentanaVista::class.java)
            startActivity(inte)
        }

        val option = arrayOf("...","Tediore","Maliwan","Jackobs","Torgue")
        adapterFabri =ArrayAdapter<String>(this,R.layout.simple_list_item_1,option)
        binding.spFabricante.adapter = adapterFabri

        binding.spFabricante.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fabricante = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val optionTipo = arrayOf("...","Pistol","Rocket Launcher","Shotgun","Assault rifle","SMG","Sniper")

        adapterTipo = ArrayAdapter<String>(this,R.layout.simple_list_item_1,optionTipo)
        binding.spTipo.adapter = adapterTipo
        binding.spTipo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tipo = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun asignarRestoElementos(): Arma{
        var elemento = mutableListOf<String>()
        var image = mutableListOf<String>()
        var complemento = listOf("Maxxed-Out","Creeping","Turbo","Dastardly","DeadEye","Double-Penetrating","Packin' Gratifying","Itchy","Stark")
        var rarezas = listOf("Common","Uncommon","Rare","Epic","Legendary")
        var fabricantes = listOf("Tediore","Jackobs","Torgue","Maliwan")

        var complementoArma = complemento[(complemento.indices).random()]
        var canionArma = fabricantes[(fabricantes.indices).random()]
        var gatilloArma = fabricantes[(fabricantes.indices).random()]
        var rarezaArma = rarezas[(rarezas.indices).random()]

        when(fabricante){
            "Tediore" -> {
                elemento.addAll(listOf("No element","Fire","Electric","Corrosive","Cryo","Radiation"))
            }
            "Torgue" -> {
                elemento.addAll(listOf("No element","Fire","Electric","Corrosive","Cryo","Radiation"))
            }
            "Maliwan" -> {
                elemento.addAll(listOf("Fire","Electric","Corrosive","Cryo","Radiation"))
            }
            "Jackobs" -> {
                elemento.addAll(listOf("No element"))
            }
        }

        var elementoArma = elemento[(elemento.indices).random()]

        when(tipo){
            "Pistol" -> image.addAll(listOf("pistol1","pistol2","pistol3","pistol4"))
            "Assault Rifle" -> image.addAll(listOf("assault1","assault2"))
            "Shotgun" -> image.addAll(listOf("shotgun1","shotgun2","shotgun3","shotgun4"))
            "Sniper" -> image.addAll(listOf("sniper1","sniper2"))
            "SMG" -> image.addAll(listOf("smg1","smg2"))
            "RocketLauncher" -> image.addAll(listOf("rocketlauncher1"))
        }

        var imageArma = image[(image.indices).random()]

        var a = Arma(binding.edNombreMain.text.toString(),fabricante,imageArma,tipo,rarezaArma,gatilloArma,canionArma,elementoArma,complementoArma)


        return a

    }

    fun addArma(view: View) {
        if (binding.edNombreMain.text.toString().trim().isEmpty()|| fabricante == "..."
            || tipo == "..."){
            Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
        }
        else {
            var pers: Arma = asignarRestoElementos()
            var codigo= Conexion.addArma(this, pers)
            binding.edNombreMain.setText("")
            binding.spTipo.setSelection(0)
            binding.spFabricante.setSelection(0)
            binding.edNombreMain.requestFocus()
            //la L es por ser un Long lo que trae codigo.
            if(codigo!=-1L) {
                Toast.makeText(this, "Arma insertada", Toast.LENGTH_SHORT).show()
                listarArma(view)
            }
            else
                Toast.makeText(this, "Ya existe ese Nombre. Arma NO insertada", Toast.LENGTH_SHORT).show()
        }
    }

    fun delArma(view: View) {
        var cant = Conexion.delArma(this, binding.edNombreMain.text.toString())
        binding.edNombreMain.setText("")
        binding.spTipo.setSelection(0)
        binding.spFabricante.setSelection(0)
        if (cant == 1) {
            Toast.makeText(this, "Se borró el arma", Toast.LENGTH_SHORT).show()
            listarArma(view)
        }
        else
            Toast.makeText(this, "No existe ese arma", Toast.LENGTH_SHORT).show()

    }

    fun modArma(view: View) {
        if (binding.edNombreMain.text.toString().trim().isEmpty()|| fabricante == "..."
            || tipo == "..."){
            Toast.makeText(this, "Campos en blanco", Toast.LENGTH_SHORT).show()
        }
        else {
            var arma: Arma = asignarRestoElementos()
            var cant = Conexion.modArma(this, binding.edNombreMain.text.toString(), arma)
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe ese arma", Toast.LENGTH_SHORT).show()
        }
        listarArma(view)
    }

    fun buscarArma(view: View) {
        var a:Arma? = null
        a = Conexion.buscarArma(this, binding.edNombreMain.text.toString())
        if (a!=null) {
            binding.spFabricante.setSelection(adapterFabri.getPosition(a.fabricante))
            binding.spTipo.setSelection(adapterTipo.getPosition(a.tipo))
        } else {
            Toast.makeText(this, "No existe ese arma", Toast.LENGTH_SHORT).show()
        }

    }

    fun listarArma(view: View) {
        var listado:ArrayList<Arma> = Conexion.obtenerArmas(this)
        binding.txtListado.setText("")

        if (listado.size==0) {
            Toast.makeText(this, "No existen datos en la tabla", Toast.LENGTH_SHORT).show()
        }
        else {
            for(a in listado){
                var cadena = a.nombre + ", " + a.tipo + ", " + a.fabricante + "\r\n"
                binding.txtListado.append(cadena)
            }
        }
    }
}