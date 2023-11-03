package com.example.recyclerborderlandsweaponsqlite

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
import com.example.recyclerborderlandsweaponsqlite.databinding.ActivityVentanaVistaBinding

class VentanaVista : AppCompatActivity() {
    lateinit var binding: ActivityVentanaVistaBinding
    lateinit var miRecyclerView: RecyclerView

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var contextoPrincipal: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaVistaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("ACSCO", Almacen.armas.toString())

        miRecyclerView = binding.recyclerView
        miRecyclerView.setHasFixedSize(true)
        miRecyclerView.layoutManager= LinearLayoutManager(this)
        var miAdapter = MiAdaptadorRecycler(Almacen.armas,this)
        miRecyclerView.adapter = miAdapter

        binding.btnVolver.setOnClickListener {
            finish()
        }

        contextoPrincipal = this
    }
}