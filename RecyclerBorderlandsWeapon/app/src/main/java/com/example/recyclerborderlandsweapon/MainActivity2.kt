package com.example.recyclerborderlandsweapon

import Modelo.Arma
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerborderlandsweapon.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var p  = intent.getSerializableExtra("obj") as Arma

        val uri = "@drawable/"+p.imagen
        val imageResource: Int =
            this.getResources().getIdentifier(uri, null, this.packageName)
        var res: Drawable = this.resources.getDrawable(imageResource)
        binding.imageView.setImageDrawable(res)

        binding.etNombreM2.setText(p.nombre)
        binding.etComplemento.setText(p.complemento)
        binding.etFabricante2.setText(p.fabricante)
        binding.etRareza.setText(p.rareza)
        binding.etElemento.setText(p.elemento)
        binding.etGatillo.setText(p.gatillo)
        binding.etCanion.setText(p.canion)

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}