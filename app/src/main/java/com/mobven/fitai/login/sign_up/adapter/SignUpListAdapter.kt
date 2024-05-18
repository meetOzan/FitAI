package com.mobven.fitai.login.sign_up.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R
import com.mobven.fitai.databinding.CardSignUpBinding
import com.mobven.fitai.login.sign_up.SignUpSelectorItem

class SignUpListAdapter(private val context: Context) :
    ListAdapter<SignUpSelectorItem, SignUpListAdapter.ViewHolder>(SignUpItemDiffUtil()) {

    inner class ViewHolder(private val binding: CardSignUpBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SignUpSelectorItem) {
            with(binding) {

                radioButtonText.text = item.title

                cardSignUp.setOnClickListener {
                    selectItem(currentList,adapterPosition)
                }

                if (item.isSelected) {
                    binding.cardSignUpItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.light_grey_3
                        )
                    )
                    binding.radioButtonImage.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
                    binding.checkboxImageSignUpItem.visibility = View.VISIBLE
                } else {
                    binding.cardSignUpItem.setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
                    binding.radioButtonImage.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.light_grey_3
                        )
                    )
                    binding.checkboxImageSignUpItem.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun selectItem(items: List<SignUpSelectorItem>,position: Int) {
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