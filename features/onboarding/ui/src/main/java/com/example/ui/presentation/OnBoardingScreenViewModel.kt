package com.example.ui.presentation

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.SetAuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

public class OnBoardingScreenViewModel(
    private val setAuthUseCase: SetAuthUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow("")
    public val uiState: StateFlow<String> = _uiState.asStateFlow()

    public fun setAuth() {
        //setAuthUseCase("123")
    }

}