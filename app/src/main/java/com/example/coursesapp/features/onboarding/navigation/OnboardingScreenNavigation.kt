package com.example.coursesapp.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.features.onboarding.OnboardingScreen

const val ONBOARD_ROUTE = "onboarding"

fun NavGraphBuilder.onboardingScreen(navigateToAuthorizationScreen: () -> Unit) {
    composable(route = ONBOARD_ROUTE) {
        OnboardingScreen(navigateToAuthorizationScreen = navigateToAuthorizationScreen)
    }
}