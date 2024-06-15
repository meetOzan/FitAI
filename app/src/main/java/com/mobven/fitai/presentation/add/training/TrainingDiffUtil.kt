package com.mobven.fitai.presentation.add.training

import androidx.recyclerview.widget.DiffUtil

class TrainingDiffUtil : DiffUtil.ItemCallback<TrainingModel>() {
    override fun areItemsTheSame(oldItem: TrainingModel, newItem: TrainingModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TrainingModel, newItem: TrainingModel): Boolean {
        return oldItem == newItem
    }
}
