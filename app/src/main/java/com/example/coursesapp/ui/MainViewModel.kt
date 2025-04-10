package com.example.coursesapp.ui

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.IsAuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

public class MainViewModel(
    isAuthUseCase: IsAuthUseCase
) : ViewModel() {
    private val _isAuthenticated = MutableStateFlow(false)
    public val isAuthenticated: StateFlow<Boolean> get() = _isAuthenticated

    init {
        _isAuthenticated.value = isAuthUseCase()
    }
}