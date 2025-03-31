package com.example.coursesapp.features.courses.domain.usecase

import com.example.coursesapp.features.courses.domain.models.Course
import kotlinx.coroutines.flow.Flow

interface GetFavoriteCoursesUseCase {
    suspend operator fun invoke(): Flow<List<Course>>
}