package com.mobven.fitai.presentation.login.sign_up.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R
import com.mobven.fitai.databinding.CardSignUpBinding
import com.mobven.fitai.presentation.login.sign_up.model.SignUpSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class SignUpListAdapter :
    ListAdapter<SignUpSelectorItem, SignUpListAdapter.ViewHolder>(SignUpItemDiffUtil()) {

    inner class ViewHolder(private val binding: CardSignUpBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SignUpSelectorItem) {
            with(binding) {

                radioButtonText.text = item.title

                cardSignUp.setOnClickListener {
                    if (item.type == SignUpSelectorType.RADIO) {
                        selectItem(currentList, adapterPosition)
                        notifyItemChanged(adapterPosition)
                    } else {
                        item.isSelected = !item.isSelected
                        notifyItemChanged(adapterPosition)
                    }
                }

                if (item.type == SignUpSelectorType.RADIO) {
                    checkboxImageSignUpItem.visibility = View.INVISIBLE
                } else {
                    checkboxImageSignUpItem.visibility = View.VISIBLE
                }

                if (item.isSelected) {
                    cardSignUpItem.setBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.light_grey_3
                        )
                    )
                    radioButtonImage.setColorFilter(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white
                        )
                    )
                    checkboxImageSignUpItem.visibility = View.VISIBLE
                } else {
                    cardSignUpItem.setBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white
                        )
                    )
                    radioButtonImage.setColorFilter(
                        ContextCompat.getColor(
                            root.context,
                            R.color.light_grey_3
                        )
                    )
                    checkboxImageSignUpItem.visibility = View.INVISIBLE
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun selectItem(items: List<SignUpSelectorItem>, position: Int) {
        items.forEachIndexed { index, item ->
            item.isSelected = index == position
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardSignUpBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}