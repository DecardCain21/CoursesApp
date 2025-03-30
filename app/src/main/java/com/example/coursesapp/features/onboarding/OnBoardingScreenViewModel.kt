package com.example.coursesapp.features.onboarding

import androidx.lifecycle.ViewModel
import com.example.coursesapp.features.onboarding.domain.SetAuthUseCase

class OnBoardingScreenViewModel(
    private val setAuthUseCase: SetAuthUseCase
) : ViewModel() {

    fun setAuth() {
        setAuthUseCase("123")
    }

}