package com.example.demo_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txv: TextView
    private lateinit var start: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv = findViewById(R.id.txv)
        start = findViewById(R.id.start)

        start.setOnClickListener({
            val intent1 = Intent(this, GameStart_Activity::class.java)
            startActivity(intent1)
        })

    }
}