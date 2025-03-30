package com.example.coursesapp.core.network.di

import com.example.coursesapp.core.network.CoursesApiService
import com.example.coursesapp.core.network.client.CoursesNetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(CoursesApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoursesApiService::class.java)
    }

    singleOf(::CoursesNetworkClient)

}