package com.example.arworkforgraduation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arworkforgraduation.data.model.Category
import com.example.arworkforgraduation.databinding.ItemVerticalBinding

class CategoryAdapter(
    private val list: List<Category>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemVerticalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(list[position])
    }

    class ViewHolder(val binding: ItemVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.item = item
            binding.ivCategory.setImageResource(item.image)
        }
    }
}