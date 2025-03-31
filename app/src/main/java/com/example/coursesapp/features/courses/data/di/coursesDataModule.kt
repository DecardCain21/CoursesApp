package com.example.coursesapp.features.courses.data.di

import androidx.room.Room
import com.example.coursesapp.features.courses.data.db.CoursesDataBase
import com.example.coursesapp.features.courses.data.repository.CoursesFavoriteRepositoryImpl
import com.example.coursesapp.features.courses.data.repository.CoursesRepositoryImpl
import com.example.coursesapp.features.courses.domain.api.CoursesFavoriteRepository
import com.example.coursesapp.features.courses.domain.api.CoursesRepository
import com.example.coursesapp.features.courses.domain.usecase.AddFavoriteCourseUseCase
import com.example.coursesapp.features.courses.domain.usecase.AddFavoriteCourseUseCaseImpl
import com.example.coursesapp.features.courses.domain.usecase.GetCoursesUseCase
import com.example.coursesapp.features.courses.domain.usecase.GetCoursesUseCaseImpl
import com.example.coursesapp.features.courses.domain.usecase.GetFavoriteCoursesUseCase
import com.example.coursesapp.features.courses.domain.usecase.GetFavoriteCoursesUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coursesDataModule = module {

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = CoursesDataBase::class.java,
            name = "database.db"
        ).fallbackToDestructiveMigration().build()
    }

    singleOf(::CoursesRepositoryImpl) bind CoursesRepository::class

    /*single <CoursesRepository>{
        CoursesRepositoryImpl(get())
    }*/

    singleOf(::GetCoursesUseCaseImpl) bind GetCoursesUseCase::class

    singleOf(::CoursesFavoriteRepositoryImpl) bind CoursesFavoriteRepository::class

    singleOf(::GetCoursesUseCaseImpl) bind GetCoursesUseCase::class

    singleOf(::AddFavoriteCourseUseCaseImpl) bind AddFavoriteCourseUseCase::class

    singleOf(::GetFavoriteCoursesUseCaseImpl) bind GetFavoriteCoursesUseCase::class

}
