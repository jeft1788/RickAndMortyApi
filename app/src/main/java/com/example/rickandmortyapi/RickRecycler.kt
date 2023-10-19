package com.example.rickandmortyapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickRecycler(private val context: Context, private var dataset: List<RickMorty>) : RecyclerView.Adapter<RickRecycler.ViewHolder>() {

    // List of characters to display
    var list = ArrayList<Result>()

    // Set the data for the adapter and
    // notify the RecyclerView of the change
    fun setData(list  : List<Result>){
        this.list = list as ArrayList<Result>
        notifyDataSetChanged()
    }
    class ViewHolder(view : View)  : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.recyclerView)
        val characterImage : ImageView = view.findViewById(R.id.showName)
        //val characterImage = view.characterImage
        //val  name = view.showName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].image).into(holder.characterImage)

        // loading character name in text View
        holder.name.text = list[position].name
    }
}