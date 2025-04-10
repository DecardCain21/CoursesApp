package com.example.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.courses.models.Course
import com.example.features.courses.usecase.AddFavoriteCourseUseCase
import com.example.features.courses.usecase.GetCoursesUseCase
import com.example.ui.state.HomeScreenState
import com.example.ui.state.HomeScreenUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

public class HomeScreenViewModel(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val addFavoriteCourseUseCase: AddFavoriteCourseUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    public val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    init {
        loadCourses()
    }

    public fun handleEventHomeScreen(event: HomeScreenUiEvent) {
        when (event) {
            HomeScreenUiEvent.SortByDate -> sortByDate()
            is HomeScreenUiEvent.FavoriteCourse -> addFavoriteCourse(event.course)
        }
    }

    private fun addFavoriteCourse(course: Course) {
        viewModelScope.launch {
            addFavoriteCourseUseCase(course = course)
        }
    }

    private fun loadCourses() {
        viewModelScope.launch {
            val result = getCoursesUseCase()
            val newState = when (result.exceptionOrNull()) {
                is com.example.core.network.NetworkError.ServerError,
                is com.example.core.network.NetworkError.NoData,
                is com.example.core.network.NetworkError.NoInternet -> HomeScreenState.Empty

                else -> result.getOrNull()?.let {
                    HomeScreenState.Data(courses = it)
                } ?: HomeScreenState.Empty
            }
            _uiState.value = newState
        }
    }

    private fun sortByDate() {
        val currentState = uiState.value
        if (currentState is HomeScreenState.Data) {
            _uiState.update { currentState.copy(courses = currentState.courses.sortedBy { it.publishDate }) }
        } else {
            // TODO
        }
    }

}
