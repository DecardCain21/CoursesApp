package com.example.coursesapp.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavController.navigateToHomeScreen() = navigate(HOME_ROUTE) {
    popUpTo(HOME_ROUTE) {
        inclusive
    }
}

fun NavGraphBuilder.homeScreen(
) {
    composable(route = HOME_ROUTE) {
        HomeScreen()
    }
}