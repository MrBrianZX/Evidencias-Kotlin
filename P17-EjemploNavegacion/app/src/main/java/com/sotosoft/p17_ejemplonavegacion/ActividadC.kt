package com.sotosoft.p17_ejemplonavegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActividadC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_c)

        val mensaje = intent.getStringExtra("Mensaje")
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}