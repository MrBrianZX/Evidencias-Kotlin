package com.sotosoft.p18_toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    var tools: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tools = findViewById(R.id.my_toolbar)
        tools?.setTitle(R.string.app_name)
        setSupportActionBar(tools)

        val btP2 = findViewById<Button>(R.id.btP2)
        btP2.setOnClickListener {
            val intent = Intent(this, Pantalla2::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        val itemBusqueda = menu?.findItem(R.id.btBusqueda)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView
        val context  = this

        vistaBusqueda.queryHint = "Escribe tu nombre"
        vistaBusqueda.setOnQueryTextFocusChangeListener{v, hasFocus ->
            Log.d("LISTENERFOCUS",hasFocus.toString())
        }

        vistaBusqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("OnQueryTextChange", newText!!)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("OnQueryTextSubmit", query!!)
                Toast.makeText(context, query!!, Toast.LENGTH_SHORT).show()

                return true
            }
        })
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.bFoco -> {
                Toast.makeText(this, "Ha presionado el boton foco", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }
        return super.onOptionsItemSelected(item)
    }
}