package com.mobven.fitai.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.databinding.CardHomeCategoriesBinding
import com.mobven.fitai.util.enums.CategoryType

class HomeCategoryAdapter :
    ListAdapter<CategoryItem, HomeCategoryAdapter.ViewHolder>(CategoryDiffUtil()) {
    class ViewHolder(private val binding: CardHomeCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            with(binding) {
                binding.tvCategoryName.text = item.name

                ivCategory.updateLayoutParams<ViewGroup.LayoutParams> {
                    width =
                        if (item.categoryType == CategoryType.TRAINING) {
                            400
                        } else {
                            750
                        }
                }

                binding.ivCategory.setImageResource(item.image)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardHomeCategoriesBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }
}
