package com.sotosoft.p19_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(items:ArrayList<Platillo>, var listener: ClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var items: ArrayList<Platillo>? = null

    init {
        this.items = items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.template_platillo,parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.foto?.setImageResource(item?.foto!!)
        holder.nombre?.text = item?.nombre
        holder.precio?.text ="$" + item?.precio.toString()
        holder.rating?.rating= item?.rating?.toFloat()!!
    }

    class ViewHolder(vista:View, listener: ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var precio:TextView? = null
        var rating: RatingBar? = null
        var listener: ClickListener? = null

        init {
            foto = vista.findViewById(R.id.foto)
            nombre = vista.findViewById(R.id.tvNombre)
            precio = vista.findViewById(R.id.tvPrecio)
            rating = vista.findViewById(R.id.tvRating)
            this.listener = listener

        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }


    }

}