package com.example.arworkforgraduation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arworkforgraduation.data.model.Category
import com.example.arworkforgraduation.databinding.ItemVerticalBinding

class CategoryAdapter(
    private val list: List<Category>,
    private val listener: ItemClickListener
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
        (holder as ViewHolder).bind(list[position], listener)
    }

    // 리스트의 각 아이템에 데이터 할당
    class ViewHolder(val binding: ItemVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category, listener: ItemClickListener) {
            binding.item = item
            binding.ivCategory.setImageResource(item.image)
            binding.root.setOnClickListener { listener.onClickItem(item.Title) }
        }
    }

    interface ItemClickListener {
        fun onClickItem(title: String)

    }
}