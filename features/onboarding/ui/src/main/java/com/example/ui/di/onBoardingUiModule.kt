package com.example.ui.di

import com.example.ui.presentation.OnBoardingScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

public val onBoardingUiModule: Module = module {

    viewModelOf(::OnBoardingScreenViewModel)

}