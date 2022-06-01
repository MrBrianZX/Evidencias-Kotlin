package com.sotosoft.p17_ejemplonavegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btIrActB)

        boton.setOnClickListener {
            var intent = Intent(this, ActividadB::class.java)
            intent.putExtra("Mensaje", "Hacia Actividad B")
            startActivity(intent)
        }
    }
}