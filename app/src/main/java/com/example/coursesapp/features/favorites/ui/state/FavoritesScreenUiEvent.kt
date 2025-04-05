package com.example.coursesapp.features.favorites.ui.state

import com.example.features.courses.models.Course

sealed interface FavoritesScreenUiEvent {
    class FavoritesCourses() : FavoritesScreenUiEvent
}
