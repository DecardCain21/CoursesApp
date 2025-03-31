package com.example.coursesapp.features.home.ui.state

import com.example.coursesapp.features.courses.domain.models.Course

sealed interface HomeScreenUiEvent {
    data object SortByDate : HomeScreenUiEvent
    data class FavoriteCourse(val course: Course) : HomeScreenUiEvent
}