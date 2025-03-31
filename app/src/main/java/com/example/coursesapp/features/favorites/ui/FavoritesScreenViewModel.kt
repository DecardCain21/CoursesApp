package com.example.coursesapp.features.favorites.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursesapp.features.courses.domain.usecase.GetFavoriteCoursesUseCase
import com.example.coursesapp.features.favorites.ui.state.FavoritesScreenState
import com.example.coursesapp.features.favorites.ui.state.FavoritesScreenUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesScreenViewModel(
    private val getFavoriteCoursesUseCase: GetFavoriteCoursesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<FavoritesScreenState>(FavoritesScreenState.Loading)
    val uiState: StateFlow<FavoritesScreenState> = _uiState.asStateFlow()

    init {
        getAllCourses()
    }

    fun handleEventFavoritesScreen(event: FavoritesScreenUiEvent) {
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