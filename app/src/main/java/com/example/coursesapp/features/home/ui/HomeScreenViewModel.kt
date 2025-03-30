package com.example.coursesapp.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursesapp.core.network.NetworkError
import com.example.coursesapp.features.home.domain.usecase.GetCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            val result = getCoursesUseCase()
            val newState = when (result.exceptionOrNull()) {
                is NetworkError.ServerError,
                is NetworkError.NoData,
                is NetworkError.NoInternet -> HomeScreenState.Empty
                else -> result.getOrNull()?.let {
                    HomeScreenState.Data(courses = it)
                } ?: HomeScreenState.Empty
            }
            _uiState.value = newState
        }
    }
}