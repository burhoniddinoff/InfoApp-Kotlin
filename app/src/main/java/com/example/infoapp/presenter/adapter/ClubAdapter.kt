package com.example.infoapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.infoapp.data.ClubData
import com.example.infoapp.databinding.ItemClubBinding

class ClubAdapter : ListAdapter<ClubData, ClubAdapter.ClubViewHolder>(ClubDiffUtil) {

    lateinit var onClick: (Int) -> Unit

    object ClubDiffUtil : DiffUtil.ItemCallback<ClubData>() {
        override fun areItemsTheSame(oldItem: ClubData, newItem: ClubData): Boolean = false
        override fun areContentsTheSame(oldItem: ClubData, newItem: ClubData): Boolean = oldItem == newItem
    }

    inner class ClubViewHolder(private val binding: ItemClubBinding) : ViewHolder(binding.root) {

        init {
            binding.layout.setOnClickListener {
                onClick.invoke(adapterPosition)
            }
        }

        fun bind() {
            val data = getItem(adapterPosition)

            binding.apply {
                imageView.setImageResource(data.img)
                clubName.text = data.name
                countryName.text = data.country
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder = ClubViewHolder(
        ItemClubBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) = holder.bind()

}