package org.karabalin.lab33

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(
    private val fruits: List<String>,
    private val itemClickListener: (String) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitNameTextView: TextView = itemView.findViewById(R.id.text_view_fruit_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.fruitNameTextView.text = fruit
        holder.itemView.setOnClickListener {
            itemClickListener(fruit)
        }
    }

    override fun getItemCount(): Int = fruits.size
}

