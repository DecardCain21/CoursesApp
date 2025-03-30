package com.example.coursesapp.features.onboarding.di

import android.content.Context
import android.content.SharedPreferences
import com.example.coursesapp.features.onboarding.OnBoardingScreenViewModel
import com.example.coursesapp.features.onboarding.data.PreferencesStorage
import com.example.coursesapp.features.onboarding.domain.IsAuthUseCase
import com.example.coursesapp.features.onboarding.domain.IsAuthUseCaseImpl
import com.example.coursesapp.features.onboarding.domain.SetAuthUseCase
import com.example.coursesapp.features.onboarding.domain.SetAuthUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val onBoardingModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            "app_preferences",
            Context.MODE_PRIVATE
        )
    }

    singleOf(::PreferencesStorage)

    singleOf(::IsAuthUseCaseImpl) bind IsAuthUseCase::class

    singleOf(::SetAuthUseCaseImpl) bind SetAuthUseCase::class

    viewModelOf(::OnBoardingScreenViewModel)


}