package com.example.pacitantourism

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListTourismAdapter(private val listTourism: ArrayList<Tourism>) :
    RecyclerView.Adapter<ListTourismAdapter.ListViewHolder>() {

    private lateinit var onClickItemCallback: OnClickItemCallback

    fun setClickCallback(clickCallback: OnClickItemCallback){
        onClickItemCallback = clickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tourism = listTourism[position]

        Glide.with(holder.itemView.context).load(tourism.image).into(holder.itemImg)

        holder.itemTitle.text = tourism.title
        holder.itemDesc.text = tourism.description

        holder.itemButton.setOnClickListener {
            onClickItemCallback.onClickItem(tourism)
        }
    }

    override fun getItemCount(): Int {
        return listTourism.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImg: ImageView = itemView.findViewById(R.id.item_img)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDesc: TextView = itemView.findViewById(R.id.item_desc)
        var itemButton: Button = itemView.findViewById(R.id.item_button)
    }
}

interface OnClickItemCallback{
    fun onClickItem(tourism: Tourism)
}