package com.muema.mohsenapp2.swipe_rec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muema.mohsenapp2.R

class SwipeAdapter(private val swipeList: ArrayList<SwipeDataClass>) : RecyclerView.Adapter<SwipeAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.swipe_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val currentItem = swipeList[position]

        holder.positionTitle.text = currentItem.swipePosition
    }

    override fun getItemCount(): Int {

        return swipeList.size
    }

    fun deleteItem(adapterPosition: Int) {

        swipeList.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val positionTitle: TextView = itemView.findViewById(R.id.txtPosition)
    }
}