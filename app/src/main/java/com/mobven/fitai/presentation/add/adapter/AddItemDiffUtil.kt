package com.mobven.fitai.presentation.add.adapter

import androidx.recyclerview.widget.DiffUtil

class AddItemDiffUtil : DiffUtil.ItemCallback<AddItemModel>() {
    override fun areItemsTheSame(oldItem: AddItemModel, newItem: AddItemModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AddItemModel, newItem: AddItemModel): Boolean {
        return oldItem.title == newItem.title || oldItem.image == newItem.image || oldItem.description == newItem.description
    }
}