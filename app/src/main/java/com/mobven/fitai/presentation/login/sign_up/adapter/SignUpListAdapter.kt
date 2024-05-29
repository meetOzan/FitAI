package com.mobven.fitai.presentation.login.sign_up.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R
import com.mobven.fitai.databinding.CardSelectorBinding
import com.mobven.fitai.presentation.login.sign_up.model.ListSelectorItem
import com.mobven.fitai.util.enums.SignUpSelectorType

class SignUpListAdapter :
    ListAdapter<ListSelectorItem, SignUpListAdapter.ViewHolder>(SignUpItemDiffUtil()) {
    inner class ViewHolder(private val binding: CardSelectorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListSelectorItem) {
            with(binding) {
                radioButtonText.text = item.title
                radioButtonImage.setImageResource(item.image)

                if (item.image == 0) {
                    radioButtonImageBackground.visibility = View.GONE
                } else {
                    radioButtonImageBackground.visibility = View.VISIBLE
                }

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
                            R.color.light_grey_3,
                        ),
                    )
                    radioButtonImageBackground.setColorFilter(
                        ContextCompat.getColor(
                            root.context,
                            R.color.green_500,
                        ),
                    )
                    cardSignUp.strokeColor = ContextCompat.getColor(root.context, R.color.green_500)
                    checkboxImageSignUpItem.visibility = View.VISIBLE
                } else {
                    cardSignUpItem.setBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white,
                        ),
                    )
                    cardSignUp.strokeColor =
                        ContextCompat.getColor(root.context, R.color.light_grey)
                    radioButtonImageBackground.setColorFilter(
                        ContextCompat.getColor(
                            root.context,
                            R.color.light_grey,
                        ),
                    )
                    checkboxImageSignUpItem.visibility = View.INVISIBLE
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun selectItem(
        items: List<ListSelectorItem>,
        position: Int,
    ) {
        items.forEachIndexed { index, item ->
            item.isSelected = index == position
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardSelectorBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }
}
