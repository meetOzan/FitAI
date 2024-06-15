package com.mobven.fitai.infrastructure.string_resource

import android.content.Context

class StringResourceProviderImpl(
    private val context: Context
) : StringResourceProvider{

    override fun getString(id: Int): String =  context.getString(id)

}