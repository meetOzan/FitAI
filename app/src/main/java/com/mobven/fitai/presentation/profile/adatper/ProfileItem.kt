package com.mobven.fitai.presentation.profile.adatper

import com.mobven.fitai.util.enums.ProfileItemType

data class ProfileItem(
    val image: Int,
    val text: String,
    val type: ProfileItemType,
)