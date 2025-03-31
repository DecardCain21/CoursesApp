package com.example.coursesapp.features.home.ui.di

import com.example.coursesapp.features.home.ui.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeUiModule = module {
    viewModelOf(::HomeScreenViewModel)
}
