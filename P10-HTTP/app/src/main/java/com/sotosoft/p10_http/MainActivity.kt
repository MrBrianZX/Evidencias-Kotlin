package com.sotosoft.p10_http

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnValidar = findViewById<Button>(R.id.bValidarRed)
        val btnHTTP = findViewById<Button>(R.id.btnHTTP)
        btnValidar.setOnClickListener {
            //Codigo validar
            if(Network.isNetworkAvailable(this))
                Toast.makeText(this,"Hay red :D",Toast.LENGTH_LONG).show()

            else
                Toast.makeText(this,"No hay red :C",Toast.LENGTH_LONG).show()
        }
        btnHTTP.setOnClickListener {
            if(Network.isNetworkAvailable(this)){
                solicitudHTTP("https://www.google.com")
            }
            else
                Toast.makeText(this,"No hay red :C",Toast.LENGTH_LONG).show()
        }

    }

    private fun solicitudHTTP(url:String){
        val cola  = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, {
            response ->
            try {
                if(response != null)
                    Toast.makeText(this,"Se obtuvo respuesta del servidor",Toast.LENGTH_LONG).show()
            } catch (e : Exception){
                Toast.makeText(this,"NO Se obtuvo respuesta del servidor",Toast.LENGTH_LONG).show()
            }
        }, {  })

        cola.add(solicitud)
    }

}