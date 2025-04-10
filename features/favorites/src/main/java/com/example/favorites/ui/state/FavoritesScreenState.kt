package com.example.favorites.ui.state

import com.example.features.courses.models.Course

public interface FavoritesScreenState {
    public data object Loading : FavoritesScreenState
    public data object Error : FavoritesScreenState
    public data object Empty : FavoritesScreenState
    public data class Data(val courses: List<Course>) : FavoritesScreenState
}
