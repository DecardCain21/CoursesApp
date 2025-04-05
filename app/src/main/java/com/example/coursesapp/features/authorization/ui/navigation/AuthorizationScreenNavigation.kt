package com.example.coursesapp.features.authorization.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.features.authorization.ui.AuthorizationScreen

public const val AUTH_ROUTE: String = "authorization"

public fun NavController.navigateToAuthorizationScreen(): Unit = navigate(AUTH_ROUTE) {
    popUpTo(AUTH_ROUTE) {
        inclusive = true
    }
}

public fun NavGraphBuilder.authorizationScreen(
    navigateToMainScreen: () -> Unit
) {
    composable(route = AUTH_ROUTE) {
        AuthorizationScreen(navigateToMainScreen = navigateToMainScreen)
    }
}
