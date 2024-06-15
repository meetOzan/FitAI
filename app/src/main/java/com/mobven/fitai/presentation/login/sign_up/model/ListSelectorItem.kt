package com.mobven.fitai.presentation.login.sign_up.model

import com.mobven.fitai.util.enums.SignUpSelectorType

data class ListSelectorItem(
    val title: String,
    var isSelected: Boolean,
    val type: SignUpSelectorType,
    val image: Int = 0,
)
