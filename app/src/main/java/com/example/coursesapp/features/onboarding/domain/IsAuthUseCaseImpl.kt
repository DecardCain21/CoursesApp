package com.example.coursesapp.features.onboarding.domain

import com.example.coursesapp.features.onboarding.data.PreferencesStorage

class IsAuthUseCaseImpl(private val preferencesStorage: PreferencesStorage) : IsAuthUseCase {
    override fun invoke(): Boolean {
        return preferencesStorage.isAuthenticated()
    }
}