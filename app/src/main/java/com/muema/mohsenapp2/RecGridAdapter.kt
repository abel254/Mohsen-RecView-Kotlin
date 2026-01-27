package com.muema.mohsenapp2

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

class RecGridAdapter(private val pizzaList: ArrayList<PizzaGrid>) : RecyclerView.Adapter<RecGridAdapter.ViewHolder>( ){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
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

            val intent = Intent(it.context, RecGridSecondActivity::class.java)

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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageTitle = itemView.findViewById<ImageView>(R.id.imgTitleGrid)
        val txtName = itemView.findViewById<TextView>(R.id.txtNameGrid)
        val txtIng = itemView.findViewById<TextView>(R.id.txtIngGrid)
        val constraintRow: ConstraintLayout = itemView.findViewById(R.id.constraintRowGrid)
        val cardView: CardView = itemView.findViewById(R.id.pizzaGridCardview)
    }
}