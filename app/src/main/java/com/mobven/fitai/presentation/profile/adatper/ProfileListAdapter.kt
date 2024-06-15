package com.mobven.fitai.presentation.profile.adatper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardProfileItemBinding
import com.mobven.fitai.util.enums.ProfileItemType

class ProfileListAdapter : ListAdapter<ProfileItem, ProfileListAdapter.ProfileViewHolder>(
    ProfileDiffUtil()
){

    inner class ProfileViewHolder(private val binding: CardProfileItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProfileItem){
            with(binding){

                // Gelen itemdan card'a set işlemi
                profileItemText.text = item.text
                profileItemImage.setImageResource(item.image)

                // Item tipine göre sağ taraftaki görsellerin görünürlüğü ayarlanıyor
                // Örnek: Switch varsa diğer textler görünmez
                when(item.type){
                    ProfileItemType.SIMPLE -> {
                        switchProfileItem.visibility = View.INVISIBLE
                        tvOnOffProfileItem.visibility = View.INVISIBLE
                    }
                    ProfileItemType.ON_OFF -> {
                        switchProfileItem.visibility = View.INVISIBLE
                        tvOnOffProfileItem.visibility = View.VISIBLE
                    }
                    ProfileItemType.TOGGLE -> {
                        switchProfileItem.visibility = View.VISIBLE
                        tvOnOffProfileItem.visibility = View.INVISIBLE
                        ivRightArrowProfile.visibility = View.INVISIBLE
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardProfileItemBinding.inflate(layoutInflater, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}