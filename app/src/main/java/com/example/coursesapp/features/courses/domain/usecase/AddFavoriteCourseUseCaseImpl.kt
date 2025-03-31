package com.example.coursesapp.features.courses.domain.usecase

import com.example.coursesapp.features.courses.domain.api.CoursesFavoriteRepository
import com.example.coursesapp.features.courses.domain.models.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddFavoriteCourseUseCaseImpl(private val favoriteRepository: CoursesFavoriteRepository) :
    AddFavoriteCourseUseCase {
    override suspend fun invoke(course: Course) = withContext(Dispatchers.IO) {
        favoriteRepository.saveCourseInDb(course)
    }
}