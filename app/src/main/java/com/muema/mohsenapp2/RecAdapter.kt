package com.muema.mohsenapp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.animation.AnimationUtils

class RecAdapter(private val pizzaList: ArrayList<Pizza>) : RecyclerView.Adapter<RecAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val currentItem = pizzaList[position]

        holder.imageTitle.setImageResource(currentItem.imageTitle)
        holder.txtName.text = currentItem.name
        holder.txtIng.text = currentItem.ingredients

        val cont = holder.constraintRow.context
        holder.constraintRow.setOnClickListener {
            val intent = Intent(it.context, RecSecondActivity::class.java)

            intent.putExtra("image", currentItem.imageTitle)
            intent.putExtra("title", currentItem.name)
            intent.putExtra("ingredients", currentItem.ingredients)

            it.context.startActivity(intent)

            Toast.makeText(cont, "the item ${currentItem.name} is clicked", Toast.LENGTH_SHORT).show()
        }

        holder.cardView.startAnimation(android.view.animation.AnimationUtils.loadAnimation(holder.cardView.context, R.anim.scale_up))
    }

    override fun getItemCount(): Int {
       return pizzaList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageTitle = itemView.findViewById<ImageView>(R.id.imgTitle)
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtIng = itemView.findViewById<TextView>(R.id.txtIng)
        val constraintRow: ConstraintLayout = itemView.findViewById(R.id.constraintRow)
        val cardView: CardView = itemView.findViewById(R.id.pizzaCardview)
    }
}