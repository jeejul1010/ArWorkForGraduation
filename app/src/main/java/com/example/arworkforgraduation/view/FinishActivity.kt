package com.example.arworkforgraduation.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.arworkforgraduation.R

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val back = findViewById<ImageView>(R.id.iv_back)
        back.setOnClickListener{
            onBackPressed()
        }
    }
}