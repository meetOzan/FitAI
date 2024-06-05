package com.mobven.fitai.presentation.add.adapter

import com.mobven.fitai.util.enums.SelectItemType

data class AddItemModel(
    val title: String,
    val image: Int,
    val description: String,
    val type: SelectItemType
)
