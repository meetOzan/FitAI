package com.mobven.fitai.presentation.profile

import com.mobven.fitai.util.enums.ProfileItemType

data class ProfileItem(
    val image: Int,
    val text: String,
    val type: ProfileItemType,
)