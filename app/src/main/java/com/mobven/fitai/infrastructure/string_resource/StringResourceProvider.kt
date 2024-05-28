package com.mobven.fitai.infrastructure.string_resource

import androidx.annotation.StringRes

fun interface StringResourceProvider {

    fun getString(@StringRes id: Int) : String

}