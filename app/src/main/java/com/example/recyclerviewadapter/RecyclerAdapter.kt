package com.example.recyclerviewadapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter (private var titles:List<String>, private var details: List<String>, private var images:List<Int>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemDetail: TextView =itemView.findViewById(R.id.description)
        val itemPicture: ImageView =itemView.findViewById(R.id.iv_image)

        init {
            // Define click listener for the ViewHolder's View.
            itemView.setOnClickListener{
                val position:Int =adapterPosition
                Toast.makeText(itemView.context," You clicked on item # ${position+1}", Toast.LENGTH_SHORT)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)

    }



    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text=titles[position]
        holder.itemDetail.text=details[position]
        holder.itemPicture.setImageResource(images[position])


    }
    override fun getItemCount(): Int {
        return titles.size

    }

}