package com.example.favorites.di

import com.example.favorites.ui.FavoritesScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

public val favoritesUiModule: Module = module {
    viewModelOf(::FavoritesScreenViewModel)
}