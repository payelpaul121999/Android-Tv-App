package com.payelpaul.androidtvapp.modulle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.payelpaul.androidtvapp.R

class CategoryAdapter(
    private val items: List<String>,
    private val listenerOnItemPressed: (String) -> Unit) : RecyclerView.Adapter<CategoryAdapter.StringViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        // Inflate the custom layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_card_item, parent, false)
        return StringViewHolder(view)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        // Bind data to the ViewHolder
        val itemTab = items[position]
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listenerOnItemPressed(itemTab)
        }
    }

    override fun getItemCount(): Int = items.size

    class StringViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tabTextName)

        fun bind(text: String) {
            textView.text = text
        }
    }
}
