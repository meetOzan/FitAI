package com.mobven.fitai.presentation.profile.adatper

import androidx.recyclerview.widget.DiffUtil

class ProfileDiffUtil : DiffUtil.ItemCallback<ProfileItem>(){
    override fun areItemsTheSame(oldItem: ProfileItem, newItem: ProfileItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProfileItem, newItem: ProfileItem): Boolean {
        return oldItem.text == newItem.text && oldItem.image == newItem.image
    }
}