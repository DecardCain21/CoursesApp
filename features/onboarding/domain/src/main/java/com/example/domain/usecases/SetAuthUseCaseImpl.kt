package com.example.domain.usecases

import com.example.domain.data.PreferencesStorage

public class SetAuthUseCaseImpl(private val storage: com.example.domain.data.PreferencesStorage) :
    SetAuthUseCase {
    override fun invoke(value: String) {
        storage.login = value
    }
}