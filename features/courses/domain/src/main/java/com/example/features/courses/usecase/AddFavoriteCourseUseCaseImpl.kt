package com.example.features.courses.usecase

import com.example.features.courses.api.CoursesFavoriteRepository
import com.example.features.courses.models.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class AddFavoriteCourseUseCaseImpl(private val favoriteRepository: CoursesFavoriteRepository) :
    AddFavoriteCourseUseCase {
    override suspend fun invoke(course: Course): Unit = withContext(Dispatchers.IO) {
        favoriteRepository.saveCourseInDb(course)
    }
}
