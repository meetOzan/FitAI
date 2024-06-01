package com.mobven.fitai.presentation.home.adapter

import com.mobven.fitai.util.enums.CategoryType

data class CategoryItem(
    val name: String,
    val image: Int,
    val categoryType: CategoryType,
)
