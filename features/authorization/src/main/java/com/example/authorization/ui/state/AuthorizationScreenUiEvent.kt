package com.example.authorization.ui.state

public sealed interface AuthorizationScreenUiEvent {
    public data class InputLogin(val text: String) : AuthorizationScreenUiEvent
    public data class InputPassword(val text: String) : AuthorizationScreenUiEvent
    public data class EnterEnabled(val enable: Boolean = false) : AuthorizationScreenUiEvent
}