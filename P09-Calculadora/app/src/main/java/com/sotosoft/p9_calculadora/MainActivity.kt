package com.sotosoft.p9_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnCalcular)
        btn.setOnClickListener {
            Operar()
        }

    }

    fun Operar(){
        val rbSuma = findViewById<RadioButton>(R.id.rbSuma)
        val rbResta = findViewById<RadioButton>(R.id.rbResta)
        val rbMultiplicar = findViewById<RadioButton>(R.id.rbMultiplicar)
        val rbDivision = findViewById<RadioButton>(R.id.rbDivision)

        val tbnumA = findViewById<EditText>(R.id.etNumA)
        val tbnumB = findViewById<EditText>(R.id.etNumB)
        val tbRes = findViewById<EditText>(R.id.etResultado)
        val numA = tbnumA.text.toString().toDouble()
        val numB = tbnumB.text.toString().toDouble()

        when{
            rbSuma.isChecked -> tbRes.setText("${numA + numB}")
            rbResta.isChecked -> tbRes.setText("${numA - numB}")
            rbMultiplicar.isChecked -> tbRes.setText("${numA * numB}")
            rbDivision.isChecked -> tbRes.setText("${numA / numB}")
        }

    }
}