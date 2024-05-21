package com.mobven.fitai.login.sign_up.model

import com.mobven.fitai.util.SignUpSelectorType

data class SignUpSelectorItem(
    val title: String,
    var isSelected: Boolean,
    val type: SignUpSelectorType
)