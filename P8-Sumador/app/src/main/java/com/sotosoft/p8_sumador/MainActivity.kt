package com.sotosoft.p8_sumador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnRes)
        button.setOnClickListener {
            sumar();
        }
    }

    fun sumar(){
        val tbnumA = findViewById<EditText>(R.id.tbNumA)
        val tbnumB = findViewById<EditText>(R.id.tbNumB)
        val tbRes = findViewById<EditText>(R.id.tbRes)
        val numA = tbnumA.text.toString().toDouble()
        val numB = tbnumB.text.toString().toDouble()
        tbRes.setText("${numA+numB}")
    }

}