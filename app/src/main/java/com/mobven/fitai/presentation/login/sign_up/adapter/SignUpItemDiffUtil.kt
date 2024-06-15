package com.mobven.fitai.presentation.login.sign_up.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem

class SignUpItemDiffUtil : DiffUtil.ItemCallback<ListSelectorItem>() {
    override fun areItemsTheSame(oldItem: ListSelectorItem, newItem: ListSelectorItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListSelectorItem, newItem: ListSelectorItem): Boolean {
        return oldItem.title == newItem.title
    }
}