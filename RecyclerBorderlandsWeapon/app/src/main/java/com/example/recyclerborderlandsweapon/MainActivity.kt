package com.example.recyclerborderlandsweapon

import Adaptadores.MiAdaptadorRecycler
import Modelo.Almacen
import Modelo.FactoriaListaArmas
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerborderlandsweapon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var miRecyclerView: RecyclerView

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var contextoPrincipal: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Almacen.armas = FactoriaListaArmas.generaLista(30)
        Log.e("ACSCO",Almacen.armas.toString())

        miRecyclerView = binding.recyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager=LinearLayoutManager(this)
        var miAdapter = MiAdaptadorRecycler(Almacen.armas,this)
        miRecyclerView.adapter = miAdapter

        binding.btnDetalle.setOnClickListener {
            if(MiAdaptadorRecycler.seleccionado >= 0){
                val pe = Almacen.armas[MiAdaptadorRecycler.seleccionado]
                Log.e("ACSCO",pe.toString())
                var inte : Intent = Intent(contextoPrincipal, MainActivity2::class.java)
                inte.putExtra("obj", Almacen.armas[MiAdaptadorRecycler.seleccionado])
                ContextCompat.startActivity(contextoPrincipal, inte, null)
            }else{
                Toast.makeText(this,"Selecciona algo previamente", Toast.LENGTH_SHORT).show()
            }

        }

        contextoPrincipal = this
    }
}