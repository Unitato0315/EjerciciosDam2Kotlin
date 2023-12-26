package com.example.conexionylogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conexionylogin.databinding.ActivityNotificacionesBinding
import com.example.conexionylogin.databinding.ActivityUsoStorageBinding

class Notificaciones : AppCompatActivity() {
    lateinit var binding: ActivityNotificacionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}