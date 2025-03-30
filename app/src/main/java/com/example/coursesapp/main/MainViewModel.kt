package com.example.coursesapp.main

import androidx.lifecycle.ViewModel
import com.example.coursesapp.features.onboarding.domain.IsAuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    isAuthUseCase: IsAuthUseCase
) : ViewModel() {
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> get() = _isAuthenticated

    init {
        _isAuthenticated.value = isAuthUseCase()
    }
}