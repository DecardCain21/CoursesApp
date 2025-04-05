package com.example.domain.di

import android.content.Context
import android.content.SharedPreferences
import com.example.domain.data.PreferencesStorage
import com.example.domain.usecases.IsAuthUseCaseImpl
import com.example.domain.usecases.SetAuthUseCaseImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

public val onBoardingDomainModule: Module = module {
    single<SharedPreferences> {
        get<Context>().getSharedPreferences(
            "app_preferences",
            Context.MODE_PRIVATE
        )
    }

    singleOf(::PreferencesStorage)

    singleOf(::IsAuthUseCaseImpl) bind com.example.domain.usecases.IsAuthUseCase::class

    singleOf(::SetAuthUseCaseImpl) bind com.example.domain.usecases.SetAuthUseCase::class

}