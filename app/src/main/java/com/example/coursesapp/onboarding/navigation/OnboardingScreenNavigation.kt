package com.example.coursesapp.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.onboarding.OnboardingScreen

const val ONBOARD_ROUTE = "onboarding"

fun NavController.navigateToOnboardingScreen() = navigate(ONBOARD_ROUTE) {
    popUpTo(ONBOARD_ROUTE) {
        inclusive
    }
}

fun NavGraphBuilder.onboardingScreen() {
    composable(route = ONBOARD_ROUTE) {
        OnboardingScreen()
    }
}