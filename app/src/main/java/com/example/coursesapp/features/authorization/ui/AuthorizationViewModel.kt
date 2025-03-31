package com.example.coursesapp.features.authorization.ui

import androidx.lifecycle.ViewModel
import com.example.coursesapp.features.authorization.ui.state.AuthorizationScreenState
import com.example.coursesapp.features.authorization.ui.state.AuthorizationScreenUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthorizationViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            AuthorizationScreenState(
                inputValueLogin = "",
                inputValuePassword = "",
                enterEnabled = false
            )
        )
    val uiState: StateFlow<AuthorizationScreenState> = _uiState

    fun handleEvent(event: AuthorizationScreenUiEvent) {
        when (event) {
            is AuthorizationScreenUiEvent.InputLogin -> inputLoginManagement(event.text)
            is AuthorizationScreenUiEvent.InputPassword -> inputPasswordPassword(event.text)
            is AuthorizationScreenUiEvent.EnterEnabled -> onLoginAttempt(event.enable)
        }
    }

    private fun inputLoginManagement(text: String) {
        _uiState.value = uiState.value.copy(inputValueLogin = text)
    }

    private fun inputPasswordPassword(text: String) {
        _uiState.value = uiState.value.copy(inputValuePassword = text)
    }

    private fun onLoginAttempt(enable: Boolean) {
        _uiState.value = uiState.value.copy(enterEnabled = enable)
    }

}