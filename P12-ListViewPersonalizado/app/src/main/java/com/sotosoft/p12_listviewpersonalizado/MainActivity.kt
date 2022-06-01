package com.sotosoft.p12_listviewpersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var robots: ArrayList<Robot> = ArrayList()
        robots.add(Robot("Fireman", R.drawable.firesprite))
        robots.add(Robot("Ice Man", R.drawable.icesprite))
        robots.add(Robot("Elec Man", R.drawable.elecsprite))
        robots.add(Robot("Cut Man", R.drawable.cutsprite))
        robots.add(Robot("Bomb Man", R.drawable.bombsprite))
        robots.add(Robot("Guts Man", R.drawable.gutssprite))

        val lista = findViewById<ListView>(R.id.lvLista)

        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, robots)
        val adapter = AdaptadorCustom(this, robots)

        lista.adapter = adapter

        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(this, robots.get(position).nombre, Toast.LENGTH_LONG).show()  }


    }
}