package com.sotosoft.p14_gridviewpersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var robots: ArrayList<Robot> = ArrayList()
        robots.add(Robot("Metal Man", R.drawable.metalsprite))
        robots.add(Robot("Air Man", R.drawable.airsprite))
        robots.add(Robot("Bubble Man", R.drawable.bubblesprite))
        robots.add(Robot("Quick Man", R.drawable.quicksprite))
        robots.add(Robot("Crash Man", R.drawable.crashsprite))
        robots.add(Robot("Flash Man", R.drawable.flashsprite))
        robots.add(Robot("Heat Man", R.drawable.heatsprite))
        robots.add(Robot("Wood Man", R.drawable.woodsprite))

        val tabla = findViewById<GridView>(R.id.gvTabla)

        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, robots)
        val adapter = AdaptadorCustom(this, robots)

        tabla.adapter = adapter

        tabla.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(this, robots.get(position).nombre, Toast.LENGTH_LONG).show()  }


    }
}