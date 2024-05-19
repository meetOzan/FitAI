package com.mobven.fitai.login.sign_up.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem

class SignUpItemDiffUtil : DiffUtil.ItemCallback<SignUpSelectorItem>() {
    override fun areItemsTheSame(oldItem: SignUpSelectorItem, newItem: SignUpSelectorItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SignUpSelectorItem, newItem: SignUpSelectorItem): Boolean {
        return oldItem.title == newItem.title
    }
}