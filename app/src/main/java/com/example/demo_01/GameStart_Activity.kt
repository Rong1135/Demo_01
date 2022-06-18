package com.example.demo_01

import android.content.Intent
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class GameStart_Activity : AppCompatActivity() {

    private lateinit var txv: TextView
    private lateinit var job: Job
    private lateinit var mySurfaceView: MySurfaceView   // 背景繪製

    private var db = FirebaseFirestore.getInstance()
    private var user: MutableMap<String, Any> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        txv = findViewById(R.id.txv)
        mySurfaceView = findViewById(R.id.mysv)

        val intent = Intent(this, GameEnd_Activity::class.java)

        // coroutine 倒數
        job = GlobalScope.launch(Dispatchers.Main) {
            for(i in 30 downTo 1) {
                txv.text = "剩餘時間：$i"    // update text
                delay(1000)

                val canvas: Canvas = mySurfaceView.holder.lockCanvas()
                    mySurfaceView.drawSomething(canvas)
                mySurfaceView.holder.unlockCanvasAndPost(canvas)

                if(i == 1){
                    val date = SimpleDateFormat("yyyy-MM-dd hh:mm").format(Date())
                    user["日期"] = date
                    user["得分"] = mySurfaceView.Score
                    db.collection("History")
                        .add(user)

                    startActivity(intent)
                }
            }
            finish()
        }

    }

}