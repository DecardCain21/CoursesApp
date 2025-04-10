package com.example.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui.presentation.HomeScreen

public const val HOME_ROUTE: String = "home"

public fun NavController.navigateToHomeScreen(): Unit =
    navigate(HOME_ROUTE) {
        popUpTo(HOME_ROUTE) {
            inclusive
        }
    }

public fun NavGraphBuilder.homeScreen(
) {
    composable(route = com.example.ui.navigation.HOME_ROUTE) {
        HomeScreen()
    }
}
