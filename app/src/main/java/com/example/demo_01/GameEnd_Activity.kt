package com.example.demo_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameEnd_Activity : AppCompatActivity() {

    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_end)

        btn = findViewById(R.id.btn)

        btn.setOnClickListener({
            finish()
        })

    }
}