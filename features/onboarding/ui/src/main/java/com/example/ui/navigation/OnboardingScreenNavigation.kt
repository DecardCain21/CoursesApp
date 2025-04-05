package com.example.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui.presentation.OnboardingScreen

public const val ONBOARD_ROUTE: String = "onboarding"

public fun NavGraphBuilder.onboardingScreen(navigateToAuthorizationScreen: () -> Unit) {
    composable(route = ONBOARD_ROUTE) {
        OnboardingScreen(navigateToAuthorizationScreen = navigateToAuthorizationScreen)
    }
}