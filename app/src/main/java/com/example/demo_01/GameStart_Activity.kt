package com.example.demo_01

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*

class GameStart_Activity : AppCompatActivity() {

    private lateinit var txv: TextView
    private lateinit var job: Job
    private lateinit var mySurfaceView: MySurfaceView   // 背景繪製

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        txv = findViewById(R.id.txv)
        mySurfaceView = findViewById(R.id.mysv)

        // coroutine 倒數
        job = GlobalScope.launch(Dispatchers.Main) {
            for(i in 30 downTo 1) {
                txv.text = "剩餘時間：$i"    // update text
                delay(1000)

                val canvas: Canvas = mySurfaceView.holder.lockCanvas()
                    mySurfaceView.drawSomething(canvas)
                mySurfaceView.holder.unlockCanvasAndPost(canvas)
            }
            finish()
        }

    }
}