package com.anjinny.bmi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            Log.d("MainActivity", "Button 클릭")

            if (heightEditText.text.isEmpty() || heightEditText.text.toString() == "0" ||
                    weightEditText.text.isEmpty() || weightEditText.text.toString() == "0") {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //이 밑으론 빈 값이 올 수 없음음

            val height = heightEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()

            Log.d("MainActivity", "height: $height, weight: $weight")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}