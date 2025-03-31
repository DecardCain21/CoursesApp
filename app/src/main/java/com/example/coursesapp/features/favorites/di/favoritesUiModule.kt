package com.example.coursesapp.features.favorites.di

import com.example.coursesapp.features.favorites.ui.FavoritesScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val favoritesUiModule = module {
    viewModelOf(::FavoritesScreenViewModel)
}