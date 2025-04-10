package com.example.features.courses.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.features.courses.CoursesApiService
import com.example.features.courses.api.CoursesFavoriteRepository
import com.example.features.courses.api.CoursesRepository
import com.example.features.courses.client.CoursesNetworkClient
import com.example.features.courses.client.CoursesNetworkClientImpl
import com.example.features.courses.data.db.CoursesDataBase
import com.example.features.courses.data.repository.CoursesFavoriteRepositoryImpl
import com.example.features.courses.data.repository.CoursesRepositoryImpl
import com.example.features.courses.usecase.AddFavoriteCourseUseCase
import com.example.features.courses.usecase.AddFavoriteCourseUseCaseImpl
import com.example.features.courses.usecase.GetCoursesUseCase
import com.example.features.courses.usecase.GetCoursesUseCaseImpl
import com.example.features.courses.usecase.GetFavoriteCoursesUseCase
import com.example.features.courses.usecase.GetFavoriteCoursesUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

public fun coursesDataModule(application: Application): Module = module {

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = CoursesDataBase::class.java,
            name = "database.db"
        ).fallbackToDestructiveMigration().build()
    }
    single<CoursesApiService> {
        get<Retrofit>().create(CoursesApiService::class.java)
    }

    single<Context> { application.applicationContext }

    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class

    singleOf(::CoursesFavoriteRepositoryImpl) bind CoursesFavoriteRepository::class

    singleOf(::CoursesNetworkClientImpl) bind CoursesNetworkClient::class

    /*single <CoursesRepository>{
        CoursesRepositoryImpl(get())
    }*/

    singleOf(::GetCoursesUseCaseImpl) bind GetCoursesUseCase::class

    singleOf(::AddFavoriteCourseUseCaseImpl) bind AddFavoriteCourseUseCase::class

    singleOf(::GetFavoriteCoursesUseCaseImpl) bind GetFavoriteCoursesUseCase::class

}
