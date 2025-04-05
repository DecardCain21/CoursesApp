package com.example.coursesapp.main.di


import com.example.coursesapp.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

public val mainModule: Module = module {
    viewModelOf(::MainViewModel)
}