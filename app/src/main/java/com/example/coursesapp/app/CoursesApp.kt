package com.example.coursesapp.app

import android.app.Application
import android.content.Context
import com.example.coursesapp.core.network.di.networkModule
import com.example.coursesapp.features.home.di.homeModule
import com.example.coursesapp.features.onboarding.di.onBoardingModule
import com.example.coursesapp.main.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoursesApp : Application() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoursesApp)
            modules(onBoardingModule, mainModule, homeModule, networkModule)
        }
    }

    companion object {
        private var instance: CoursesApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}