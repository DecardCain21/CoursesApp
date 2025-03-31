package com.example.coursesapp.features.favorites.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.features.favorites.ui.FavoritesScreen

const val FAVORITES_ROUTE = "favorites"

fun NavGraphBuilder.favoritesScreen() {
    composable(route = FAVORITES_ROUTE) {
        FavoritesScreen()
    }
}
