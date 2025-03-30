package com.example.coursesapp.features.favorites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.features.favorites.FavoritesScreen

const val FAVORITES_ROUTE = "favorites"

fun NavGraphBuilder.favoritesScreen() {
    composable(route = FAVORITES_ROUTE) {
        FavoritesScreen()
    }
}