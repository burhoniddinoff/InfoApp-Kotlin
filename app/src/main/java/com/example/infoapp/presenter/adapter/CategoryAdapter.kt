package com.example.infoapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infoapp.data.CategoryData
import com.example.infoapp.databinding.ItemCategoryBinding

class CategoryAdapter : ListAdapter<CategoryData, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtil) {

    lateinit var onCLick: (String) -> Unit

    object CategoryDiffUtil : DiffUtil.ItemCallback<CategoryData>() {
        override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean = false
        override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean = oldItem.name == newItem.name
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onCLick.invoke(getItem(adapterPosition).name)
            }
        }

        fun bind() {
            binding.text.text = getItem(adapterPosition).name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder = CategoryViewHolder(
        ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind()

}