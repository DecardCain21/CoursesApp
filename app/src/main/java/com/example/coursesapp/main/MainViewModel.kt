package com.example.coursesapp.main

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.IsAuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

public class MainViewModel(
    isAuthUseCase: com.example.domain.usecases.IsAuthUseCase
) : ViewModel() {
    private val _isAuthenticated = MutableStateFlow(false)
    public val isAuthenticated: StateFlow<Boolean> get() = _isAuthenticated

    init {
        _isAuthenticated.value = isAuthUseCase()
    }
}