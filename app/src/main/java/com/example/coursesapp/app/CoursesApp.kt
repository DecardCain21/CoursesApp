package com.example.coursesapp.app

import android.app.Application
import android.content.Context
import com.example.authorization.ui.di.authUiModule
import com.example.core.network.di.appModule
import com.example.core.network.di.networkModule
import com.example.coursesapp.main.di.mainModule
import com.example.domain.di.onBoardingDomainModule
import com.example.favorites.di.favoritesUiModule
import com.example.features.courses.data.di.coursesDataModule
import com.example.ui.di.homeUiModule
import com.example.ui.di.onBoardingUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

public class CoursesApp : Application() {
    // Создать отдельного наследника для AppContext
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoursesApp)
            modules(
                appModule(this@CoursesApp),
                onBoardingDomainModule,
                mainModule,
                coursesDataModule(this@CoursesApp),
                networkModule,
                homeUiModule,
                authUiModule,
                favoritesUiModule,
                onBoardingUiModule
            )
        }
    }

    public companion object {
        private var instance: CoursesApp? = null

        public fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}
