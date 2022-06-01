package com.sotosoft.p18_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar

class Pantalla2 : AppCompatActivity() {
    var tools: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        tools = findViewById(R.id.my_toolbar2)
        tools?.setTitle(R.string.app_name)
        setSupportActionBar(tools)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pantalla_dos,menu)
        return super.onCreateOptionsMenu(menu)

    }
}