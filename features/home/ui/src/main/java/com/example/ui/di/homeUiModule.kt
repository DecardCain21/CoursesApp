package com.example.ui.di


import com.example.ui.presentation.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

public val homeUiModule: Module = module {
    viewModelOf(::HomeScreenViewModel)
}
