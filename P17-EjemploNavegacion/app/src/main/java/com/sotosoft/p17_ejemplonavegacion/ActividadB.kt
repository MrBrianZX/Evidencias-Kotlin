package com.sotosoft.p17_ejemplonavegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActividadB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_b)

        val botonC = findViewById<Button>(R.id.btIrActC)

        val mensaje = intent.getStringExtra("Mensaje")
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        botonC.setOnClickListener {
            var intent = Intent(this, ActividadC::class.java)
            intent.putExtra("Mensaje", "Hacia Actividad C")
            startActivity(intent)
        }
        val botonD = findViewById<Button>(R.id.btIrActD)

        botonD.setOnClickListener {
            var intent = Intent(this, ActividadD ::class.java)
            intent.putExtra("Mensaje", "Hacia Actividad D")
            startActivity(intent)
        }
    }
}