package com.example.favorites.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorites.ui.state.FavoritesScreenState
import com.example.favorites.ui.state.FavoritesScreenUiEvent
import com.example.features.courses.usecase.GetFavoriteCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

public class FavoritesScreenViewModel(
    private val getFavoriteCoursesUseCase: GetFavoriteCoursesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<FavoritesScreenState>(FavoritesScreenState.Loading)
    public val uiState: StateFlow<FavoritesScreenState> = _uiState.asStateFlow()

    init {
        getAllCourses()
    }

    public fun handleEventFavoritesScreen(event: FavoritesScreenUiEvent) {
        when (event) {
            is FavoritesScreenUiEvent.FavoritesCourses -> {
                getAllCourses()
            }
        }
    }

    private fun getAllCourses() {
        viewModelScope.launch {
            _uiState.value = FavoritesScreenState.Loading
            getFavoriteCoursesUseCase().collect { courses ->
                _uiState.value = FavoritesScreenState.Data(courses = courses)
                Log.e("FavoritesData", "$courses")
            }
        }

    }

}