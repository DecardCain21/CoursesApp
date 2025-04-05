package com.example.coursesapp.app

import android.app.Application
import android.content.Context
import com.example.core.api.AppContext
import com.example.core.network.di.appModule
import com.example.core.network.di.networkModule
import com.example.coursesapp.features.authorization.ui.di.authUiModule
import com.example.coursesapp.features.favorites.di.favoritesUiModule
import com.example.coursesapp.features.home.ui.di.homeUiModule
import com.example.coursesapp.main.di.mainModule
import com.example.domain.di.onBoardingDomainModule
import com.example.features.courses.data.di.coursesDataModule
import com.example.features.courses.di.courseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

public class CoursesApp : Application(), AppContext {
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
                coursesDataModule,
                networkModule,
                homeUiModule,
                authUiModule,
                favoritesUiModule,
                courseModule,
            )
        }
    }

    public companion object {
        private var instance: CoursesApp? = null

        public fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun getAppContext(): Context = this
}
