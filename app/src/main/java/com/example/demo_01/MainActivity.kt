package com.example.demo_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txv: TextView
    private lateinit var start: ImageView
    private lateinit var history: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv = findViewById(R.id.txv)
        start = findViewById(R.id.start)
        history = findViewById(R.id.history)

//        start.setOnClickListener({
//
//        })
//
//        history.setOnClickListener({
//
//        })

    }
}