package com.mobven.fitai.presentation.add.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardAiPoweredTrainingBinding

class TrainingAdapter :
    ListAdapter<TrainingModel, TrainingAdapter.TrainingViewHolder>(TrainingDiffUtil()) {
    class TrainingViewHolder(val binding: CardAiPoweredTrainingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(trainingModel: TrainingModel) {
            with(binding) {
                addItemImage.setImageResource(trainingModel.image!!)
                tvAiPoweredTime.text = trainingModel.minute
                tvSelectedAddItemsTitle.text = trainingModel.name
                tvSelectedAddItemsDescription.text = trainingModel.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardAiPoweredTrainingBinding.inflate(layoutInflater, parent, false)
        return TrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}