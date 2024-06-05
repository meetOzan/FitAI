package com.mobven.fitai.presentation.add.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardAiPoweredFoodBinding

class FoodAdapter : ListAdapter<FoodModel, FoodAdapter.FoodViewHolder>(FoodDiffUtil()) {

    class FoodViewHolder (val binding: CardAiPoweredFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            with(binding) {
                ivAiPoweredFood.setImageResource(foodModel.image!!)
                tvAiPoweredTime.text = foodModel.count.toString()

                if (foodModel.count == 0 || foodModel.count == 1) {
                    tvAiPoweredTime.visibility = android.view.View.GONE
                    ivAiPoweredTimeBackground.visibility = android.view.View.GONE
                } else {
                    tvAiPoweredTime.visibility = android.view.View.VISIBLE
                    ivAiPoweredTimeBackground.visibility = android.view.View.VISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardAiPoweredFoodBinding.inflate(layoutInflater, parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}