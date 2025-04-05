package com.example.domain.data

import android.content.SharedPreferences

public class PreferencesStorage(
    private val sharedPreferences: SharedPreferences
) {

    public var login: String
        get() = sharedPreferences.getString(KEY_IS_AUTHENTICATED, "") ?: ""
        set(value) = sharedPreferences.edit().putString(KEY_IS_AUTHENTICATED, value).apply()

    public fun isAuthenticated(): Boolean = login.isNotEmpty()


    public companion object {
        private const val KEY_IS_AUTHENTICATED = "is_authenticated"
    }
}