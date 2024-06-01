package com.mobven.fitai.presentation.home.adapter

import androidx.recyclerview.widget.DiffUtil

class CategoryDiffUtil : DiffUtil.ItemCallback<CategoryItem>() {
    override fun areItemsTheSame(
        oldItem: CategoryItem,
        newItem: CategoryItem,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CategoryItem,
        newItem: CategoryItem,
    ): Boolean {
        return oldItem == newItem
    }
}
