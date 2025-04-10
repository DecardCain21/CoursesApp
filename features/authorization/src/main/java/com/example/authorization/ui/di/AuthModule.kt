package com.example.authorization.ui.di

import com.example.authorization.AuthorizationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

public val authUiModule: Module = module {
    viewModelOf(::AuthorizationViewModel)

}