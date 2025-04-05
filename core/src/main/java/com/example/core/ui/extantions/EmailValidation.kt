package com.example.core.ui.extantions

import android.util.Log

public fun String.isValidEmail(): Boolean {
    // Регулярное выражение для маски "текст@текст.текст"
    val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,}\$".toRegex()
    Log.e("validEmail","${this.matches(emailRegex)}")

    return this.matches(emailRegex)
    //return this.contains(emailRegex)
}

public fun Char.isCyrillic(): Boolean {
    return this in 'а'..'я' || this in 'А'..'Я' || this == 'ё' || this == 'Ё'
}