package com.example.features.courses.usecase

import com.example.features.courses.api.CoursesFavoriteRepository
import com.example.features.courses.models.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

public class GetFavoriteCoursesUseCaseImpl(private val favoriteRepository: CoursesFavoriteRepository) :
    GetFavoriteCoursesUseCase {
    override suspend fun invoke(): Flow<List<Course>> = withContext(Dispatchers.IO) {
        favoriteRepository.getAll()
    }
}