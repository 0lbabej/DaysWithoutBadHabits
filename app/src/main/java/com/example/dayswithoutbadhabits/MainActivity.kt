package com.example.dayswithoutbadhabits

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.mainTextView)

        val sharedPref = getSharedPreferences("main", Context.MODE_PRIVATE)
        val time = sharedPref.getLong("time", -1)

        if (time == -1L){
            sharedPref.edit().putLong("time", System.currentTimeMillis()).apply()
            textView.text = "0"
        } else {
            val difference = (System.currentTimeMillis() - time) /1000
            val days = difference / (24*3600)
            textView.text = days.toString()

        }
    }
}