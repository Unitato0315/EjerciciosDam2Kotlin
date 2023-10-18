package com.example.prueba

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageButton.setImageResource(R.drawable.nin_2)
        binding.imageButton2.setImageResource(R.drawable.nin_pad)
        mediaPlayer = MediaPlayer.create(this,R.raw.francoescamilla)
        binding.imageButton.setOnClickListener {
            mediaPlayer.start()
        }
        binding.imageButton2.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(this,R.raw.francoescamilla)
        }

    }
}