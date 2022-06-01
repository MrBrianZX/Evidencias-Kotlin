package com.example.p11_listviewsimple

import android.annotation.SuppressLint
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

        var robots: ArrayList<String> = ArrayList()
        robots.add("Fire Man")
        robots.add("Ice Man")
        robots.add("Elec Man")
        robots.add("Cut Man")
        robots.add("Bomb Man")
        robots.add("Guts Man")

        val lista = findViewById<ListView>(R.id.lvLista)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, robots)

        lista.adapter = adapter

        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(this, robots.get(position), Toast.LENGTH_LONG).show()  }


    }
}