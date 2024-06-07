package com.mobven.fitai.common

import android.content.Context
import com.mobven.fitai.common.Constants.PREF_NAME

object SharedPreferencesHelper {
    fun saveIsFirstLaunch(context: Context, isFirstEntrance: Boolean) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean("isFirstEntrance", isFirstEntrance)
            apply()
        }
    }

    fun getIsFirstLaunch(context: Context): Boolean? {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isFirstEntrance", false)
    }
}