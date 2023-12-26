package com.example.tablayaout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayaout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager

    }
}