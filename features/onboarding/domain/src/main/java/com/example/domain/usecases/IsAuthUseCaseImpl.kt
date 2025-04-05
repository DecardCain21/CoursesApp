package com.example.domain.usecases

import com.example.domain.data.PreferencesStorage

public class IsAuthUseCaseImpl(private val preferencesStorage: com.example.domain.data.PreferencesStorage) :
    IsAuthUseCase {
    override fun invoke(): Boolean {
        return preferencesStorage.isAuthenticated()
    }
}