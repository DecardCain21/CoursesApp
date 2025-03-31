package com.example.coursesapp.features.authorization.ui.state

sealed interface AuthorizationScreenUiEvent {
    data class InputLogin(val text: String) : AuthorizationScreenUiEvent
    data class InputPassword(val text: String) : AuthorizationScreenUiEvent
    data class EnterEnabled(val enable: Boolean = false) : AuthorizationScreenUiEvent
}