package com.example.ui.state

import com.example.features.courses.models.Course

public sealed interface HomeScreenState {

    public data object Loading : HomeScreenState
    public data object Error : HomeScreenState
    public data object Empty : HomeScreenState
    public data class Data(val courses: List<Course>) : HomeScreenState

}
