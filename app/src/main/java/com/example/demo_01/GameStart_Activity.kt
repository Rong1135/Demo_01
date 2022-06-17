package com.example.demo_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*

class GameStart_Activity : AppCompatActivity() {

    lateinit var txv: TextView
    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        txv = findViewById(R.id.txv)

        // coroutine 倒數
        job = GlobalScope.launch(Dispatchers.Main) {
            for(i in 30 downTo 1) {
                txv.text = "剩餘時間：$i"    // update text
                delay(1000)
            }
            finish()
        }

    }
}