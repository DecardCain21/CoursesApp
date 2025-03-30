package com.example.coursesapp.features.onboarding.domain

import com.example.coursesapp.features.onboarding.data.PreferencesStorage

class SetAuthUseCaseImpl(private val storage: PreferencesStorage) : SetAuthUseCase {
    override fun invoke(value: String) {
        storage.login = value
    }
}