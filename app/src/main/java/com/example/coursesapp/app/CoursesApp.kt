package com.example.coursesapp.app

import android.app.Application
import com.example.coursesapp.features.onboarding.di.onBoardingModule
import com.example.coursesapp.main.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoursesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoursesApp)
            modules(onBoardingModule, mainModule)
        }
    }
}