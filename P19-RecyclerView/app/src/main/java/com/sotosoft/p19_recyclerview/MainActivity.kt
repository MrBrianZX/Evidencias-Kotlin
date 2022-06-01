package com.sotosoft.p19_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var lista:RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val platillos = ArrayList<Platillo>()
        platillos.add(Platillo("Platillo 1", 250.0, 3.5, R.drawable.platillo01))
        platillos.add(Platillo("Platillo 2", 250.0, 3.5, R.drawable.platillo02))
        platillos.add(Platillo("Platillo 3", 250.0, 3.5, R.drawable.platillo03))
        platillos.add(Platillo("Platillo 4", 250.0, 3.5, R.drawable.platillo04))
        platillos.add(Platillo("Platillo 5", 250.0, 3.5, R.drawable.platillo05))
        platillos.add(Platillo("Platillo 6", 250.0, 3.5, R.drawable.platillo06))
        platillos.add(Platillo("Platillo 7", 250.0, 3.5, R.drawable.platillo07))
        platillos.add(Platillo("Platillo 8", 250.0, 3.5, R.drawable.platillo08))
        platillos.add(Platillo("Platillo 9", 250.0, 3.5, R.drawable.platillo09))
        platillos.add(Platillo("Platillo 10", 250.0, 3.5, R.drawable.platillo10))



        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

        adaptador = AdaptadorCustom(platillos, object : ClickListener{
            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, "TACOS", Toast.LENGTH_SHORT).show()

            }
        })
        lista?.adapter = adaptador
    }
}