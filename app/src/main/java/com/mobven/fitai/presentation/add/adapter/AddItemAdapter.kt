package com.mobven.fitai.presentation.add.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardAddItemBinding

class AddItemAdapter : ListAdapter<AddItemModel, AddItemAdapter.ViewHolder>(AddItemDiffUtil()) {

    class ViewHolder(val binding: CardAddItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AddItemModel) {
            with(binding) {
                this.addItemImage.setImageResource(item.image)
                this.addItemTextTitle.text = item.title
                this.addItemTextDescription.text = item.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardAddItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}