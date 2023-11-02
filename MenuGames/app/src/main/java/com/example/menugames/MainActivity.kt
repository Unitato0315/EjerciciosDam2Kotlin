package com.example.menugames

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.menugames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var nombre: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarPrincipal.title = "Menu Juegos"

        setSupportActionBar(binding.toolbarPrincipal)

        binding.btnValidar.setOnClickListener {
            if( binding.edtNombre.text.toString().length >= 3){
                nombre = binding.edtNombre.text.toString()
                val builder = AlertDialog.Builder(this)

                with(builder)
                {
                    setTitle("Confirmado")
                    setMessage("El nombre introducido es valido")
                    show()
                }
            }else{
                val builder = AlertDialog.Builder(this)

                with(builder)
                {
                    setTitle("Error")
                    setMessage("El nombre introducido no es valido")
                    show()
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnOp1 -> {
                irASimonDice()
            }
            R.id.mnOp2 -> {
                irATresEnRaya()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    /*private fun irAVentanaOpcion1() {

        var miIntent: Intent = Intent(this, VentanaOpcion1::class.java)
        startActivity(miIntent)
    }*/
    //version lambda de la funcion. Unit equivale a void de Java.
    private val irASimonDice: () -> Unit = {
        if (nombre.isNotEmpty()) {
            val miIntent = Intent(this, SimonDice::class.java)
            miIntent.putExtra("nombre", nombre)
            startActivity(miIntent)
        }else{
            val builder = AlertDialog.Builder(this)

            with(builder)
            {
                setTitle("Error")
                setMessage("No has introducido ningun nombre")
                show()
            }
        }
    }

    private val irATresEnRaya: () -> Unit ={
        if (nombre.isNotEmpty()) {
            val miIntent = Intent(this, TresEnRaya::class.java)
            miIntent.putExtra("nombre", nombre)
            startActivity(miIntent)
        }else{
            val builder = AlertDialog.Builder(this)

            with(builder)
            {
                setTitle("Error")
                setMessage("No has introducido ningun nombre")
                show()
            }
        }
    }
}