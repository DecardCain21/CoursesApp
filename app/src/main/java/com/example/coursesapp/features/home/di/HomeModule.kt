package com.example.coursesapp.features.home.di

import com.example.coursesapp.features.home.data.CoursesRepository
import com.example.coursesapp.features.home.data.CoursesRepositoryImpl
import com.example.coursesapp.features.home.domain.usecase.GetCoursesUseCase
import com.example.coursesapp.features.home.domain.usecase.GetCoursesUseCaseImpl
import com.example.coursesapp.features.home.ui.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeModule = module {

    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class
    /*single <CoursesRepository>{
        CoursesRepositoryImpl(get())
    }*/
    singleOf(::GetCoursesUseCaseImpl) bind GetCoursesUseCase::class

    viewModelOf(::HomeScreenViewModel)

}