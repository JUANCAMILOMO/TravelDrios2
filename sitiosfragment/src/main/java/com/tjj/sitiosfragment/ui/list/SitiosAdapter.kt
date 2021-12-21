package com.tjj.sitiosfragment.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tjj.sitiosfragment.R
import com.tjj.sitiosfragment.modelos.Sitio


class SitiosAdapter(
    private val sitiosList: ArrayList<Sitio>,
    private val onItemClicked: (Sitio) -> Unit

) : RecyclerView.Adapter<SitiosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sitio_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitio = sitiosList[position]
        holder.itemView.setOnClickListener{onItemClicked(sitiosList[position])}
        holder.bind(sitio)

    }


    override fun getItemCount(): Int = sitiosList.size

    fun appendItems(newItems: ArrayList<Sitio>) {
        sitiosList.clear()
        sitiosList.addAll(newItems)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var nombresitio: TextView = itemView.findViewById(R.id.textView17sitio)
        private var descripcionsitio: TextView = itemView.findViewById(R.id.textView18descripcion)
        private var imageViewantioquia: ImageView = itemView.findViewById(R.id.imageViewantioquia1)
        private var imageViewpuntuacion1: ImageView = itemView.findViewById(R.id.imageView3puntuacion)


        fun bind(sitio: Sitio){
            Log.d("nombre", sitio.nombre1)
            nombresitio.text = sitio.nombre1.toString()
            descripcionsitio.text = sitio.descripcion1
            Picasso.get().load(sitio.urlPicture1).into(imageViewantioquia);
            Picasso.get().load(sitio.urlPicture2).into(imageViewpuntuacion1);




        }

    }

}
