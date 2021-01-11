package com.example.arworkforgraduation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arworkforgraduation.R
import com.example.arworkforgraduation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navMain.setOnNavigationItemSelectedListener { item ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            when(item.itemId) {
                R.id.nav_home -> true
                R.id.nav_scrap -> true
                R.id.nav_my -> true
                else -> false
            }
        }
    }
}