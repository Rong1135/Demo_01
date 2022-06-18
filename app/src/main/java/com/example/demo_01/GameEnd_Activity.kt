package com.example.demo_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class GameEnd_Activity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var txv2: TextView

    private var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_end)

        btn = findViewById(R.id.btn)
        txv2 = findViewById(R.id.txv2)

        val date = SimpleDateFormat("yyyy-MM-dd hh:mm").format(Date())

        db.collection("History")
            .whereEqualTo("日期", date)
            .get()
            .addOnCompleteListener { task ->
                var msg: String = ""
                for (document in task.result!!) {
                    msg += "得分：" + document.data["得分"]
                }
                if (msg != "") {
                    txv2.text = msg
                }
            }

        btn.setOnClickListener({
            finish()
        })

    }
}