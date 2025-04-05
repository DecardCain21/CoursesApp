package com.example.coursesapp.features.home.ui.state

import com.example.features.courses.models.Course

sealed interface HomeScreenState {

    data object Loading : HomeScreenState
    data object Error : HomeScreenState
    data object Empty : HomeScreenState
    data class Data(val courses: List<Course>) : HomeScreenState

}
