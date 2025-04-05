package com.example.coursesapp.features.favorites.ui.state

import com.example.features.courses.models.Course

interface FavoritesScreenState {
    data object Loading : FavoritesScreenState
    data object Error : FavoritesScreenState
    data object Empty : FavoritesScreenState
    data class Data(val courses: List<Course>) : FavoritesScreenState
}
