package com.example.arworkforgraduation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arworkforgraduation.R
import com.example.arworkforgraduation.data.model.Category
import com.example.arworkforgraduation.data.model.Gallery
import com.example.arworkforgraduation.databinding.ItemHorizontalBinding
import com.example.arworkforgraduation.databinding.ItemVerticalBinding

class GalleryAdapter(
    private val list: List<Gallery>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemHorizontalBinding.inflate(
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

    class ViewHolder(val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Gallery) {
            binding.item = item
            binding.ivGallery.setImageResource(item.image)
        }
    }
}