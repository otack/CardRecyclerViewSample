package com.example.cardrecyclerviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {}
    }

    override fun getItemCount(): Int {
        return 24
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}