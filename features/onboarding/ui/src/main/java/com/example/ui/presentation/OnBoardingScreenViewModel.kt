package com.example.ui.presentation

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.SetAuthUseCase

public class OnBoardingScreenViewModel(
    private val setAuthUseCase: SetAuthUseCase
) : ViewModel() {

    public fun setAuth() {
        //setAuthUseCase("123")
    }

}