package com.sotosoft.p13_gridviewsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var robots = ArrayList<String>()

        robots.add("Metal Man")
        robots.add("Air Man")
        robots.add("Bubble Man")
        robots.add("Quick Man")
        robots.add("Crash Man")
        robots.add("Flash Man")
        robots.add("Heat Man")
        robots.add("Wood Man")

        val tabla = findViewById<GridView>(R.id.gvTabla)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, robots)

        tabla.adapter = adapter

        tabla.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(this, robots.get(position), Toast.LENGTH_LONG).show()  }

    }
}