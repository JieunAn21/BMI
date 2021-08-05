package com.anjinny.bmi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height , weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0)

        val bmiValueTextView = findViewById<TextView>(R.id.bmiValueTextView)
        val bmiStringTextView = findViewById<TextView>(R.id.bmiStringTextView)

        bmiValueTextView.text = bmi.toString()
        bmiStringTextView.text = when {
            bmi >= 35 -> "고도 비만 입니다."
            bmi >= 30 -> "중도 비만 입니다."
            bmi >= 25 -> "경도 비만 입니다."
            bmi >= 23 -> "과체중 입니다."
            bmi >= 18.5 -> "정상 체중 입니다."
            else -> "저체중 입니다."
        }
    }
}