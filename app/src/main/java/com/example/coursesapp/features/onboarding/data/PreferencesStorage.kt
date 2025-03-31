package com.example.coursesapp.features.onboarding.data

import android.content.SharedPreferences

class PreferencesStorage(
    private val sharedPreferences: SharedPreferences
) {

    var login: String
        get() = sharedPreferences.getString(KEY_IS_AUTHENTICATED, "") ?: ""
        set(value) = sharedPreferences.edit().putString(KEY_IS_AUTHENTICATED, value).apply()

    fun isAuthenticated(): Boolean = login.isNotEmpty()


    companion object {
        private const val KEY_IS_AUTHENTICATED = "is_authenticated"
    }
}