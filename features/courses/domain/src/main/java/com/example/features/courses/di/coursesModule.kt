package com.example.features.courses.di

import com.example.features.courses.client.CoursesNetworkClient
import com.example.features.courses.client.CoursesNetworkClientImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

public val courseModule: Module = module {
    single {
        // val retrofit: Retrofit = get()
        // retrofit.create(CoursesNetworkClient::class.java)
        get<Retrofit>()
            .create(CoursesNetworkClient::class.java)
    }

    singleOf(::CoursesNetworkClientImpl) bind CoursesNetworkClient::class
}
