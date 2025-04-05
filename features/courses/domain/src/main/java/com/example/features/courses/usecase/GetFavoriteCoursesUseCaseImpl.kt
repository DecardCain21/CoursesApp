package com.example.features.courses.usecase

import com.example.coursesapp.features.courses.domain.api.CoursesFavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetFavoriteCoursesUseCaseImpl(private val favoriteRepository: CoursesFavoriteRepository) :
    GetFavoriteCoursesUseCase {
    override suspend fun invoke() = withContext(Dispatchers.IO) {
        favoriteRepository.getAll()
    }
}