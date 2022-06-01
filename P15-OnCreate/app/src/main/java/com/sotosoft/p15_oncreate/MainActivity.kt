package com.sotosoft.p15_oncreate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var msg = "Se ha rotado el dispositivo"
    val ID = "msg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            var msg2 = "Cada que rote el dispositivo saldra un mensaje"
            Toast.makeText(this, msg2, Toast.LENGTH_LONG).show()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        msg = savedInstanceState?.getString(ID)!!
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(ID,msg)
    }
}