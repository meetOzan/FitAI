package com.mobven.fitai.presentation.add.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardAddItemBinding
import com.mobven.fitai.util.enums.SelectItemType

class AddItemAdapter(
    private val onTrainingItemClicked: (Int) -> Unit = { _ -> },
    private val onFoodItemClicked: (Int) -> Unit = { _ -> }
) : ListAdapter<AddItemModel, AddItemAdapter.ViewHolder>(AddItemDiffUtil()) {

    inner class ViewHolder(val binding: CardAddItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AddItemModel) {

            with(binding) {
                addItemImage.setImageResource(item.image)
                addItemTextTitle.text = item.title
                addItemTextDescription.text = item.description

                addItemAddBackground.setOnClickListener {
                    if (item.type == SelectItemType.TRAINING) {
                        onTrainingItemClicked(adapterPosition)
                    } else {
                        onFoodItemClicked(adapterPosition)
                    }
                }
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