package com.example.coursesapp.features.favorites.ui.state

import com.example.coursesapp.features.courses.domain.models.Course

sealed interface FavoritesScreenUiEvent {
    class FavoritesCourses() : FavoritesScreenUiEvent
}