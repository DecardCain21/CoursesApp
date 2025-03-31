package com.example.coursesapp.features.authorization.ui.di

import com.example.coursesapp.features.authorization.ui.AuthorizationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authUiModule = module {
    viewModelOf(::AuthorizationViewModel)

}