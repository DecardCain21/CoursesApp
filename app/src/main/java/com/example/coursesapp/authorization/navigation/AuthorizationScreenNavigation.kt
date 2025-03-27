package com.example.coursesapp.authorization.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.authorization.AuthorizationScreen

const val AUTH_ROUTE = "authorization"

fun NavController.navigateToAuthorizationScreen() = navigate(AUTH_ROUTE) {
    popUpTo(AUTH_ROUTE) {
        inclusive = true
    }
}

fun NavGraphBuilder.authorizationScreen(
    navigateToMainScreen: () -> Unit
) {
    composable(route = AUTH_ROUTE) {
        AuthorizationScreen(navigateToMainScreen = navigateToMainScreen)
    }
}