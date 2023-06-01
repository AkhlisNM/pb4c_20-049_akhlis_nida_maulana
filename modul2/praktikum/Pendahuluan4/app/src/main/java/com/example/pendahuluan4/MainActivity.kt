package com.example.pendahuluan4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tombol = findViewById<Button>(R.id.klik1)
        tombol.setOnClickListener {
            Toast.makeText(applicationContext,"Indonesia",Toast.LENGTH_LONG).show()
        }

        val tombol1 = findViewById<Button>(R.id.klik2)
        tombol1.setOnClickListener {
            Toast.makeText(applicationContext,"Brazil",Toast.LENGTH_LONG).show()
        }

        val tombol2 = findViewById<Button>(R.id.klik3)
        tombol2.setOnClickListener {
            Toast.makeText(applicationContext,"Argentina",Toast.LENGTH_LONG).show()
        }
    }
}