package com.example.coursesapp.features.home.ui

import com.example.coursesapp.features.home.domain.items.Course

sealed interface HomeScreenState {

    data object Loading : HomeScreenState
    data object Error : HomeScreenState
    data object Empty : HomeScreenState
    data class Data(val courses: List<Course>) : HomeScreenState

}