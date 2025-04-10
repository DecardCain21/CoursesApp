package com.example.ui.state

import com.example.features.courses.models.Course

public sealed interface HomeScreenUiEvent {
    public data object SortByDate : HomeScreenUiEvent
    public data class FavoriteCourse(val course: Course) : HomeScreenUiEvent
}
