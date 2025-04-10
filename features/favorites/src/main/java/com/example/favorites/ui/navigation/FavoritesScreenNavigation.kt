package com.example.favorites.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.favorites.ui.FavoritesScreen

public const val FAVORITES_ROUTE: String = "favorites"

public fun NavGraphBuilder.favoritesScreen() {
    composable(route = com.example.favorites.ui.navigation.FAVORITES_ROUTE) {
        FavoritesScreen()
    }
}
