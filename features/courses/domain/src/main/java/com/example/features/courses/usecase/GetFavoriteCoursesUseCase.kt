package com.example.features.courses.usecase

import com.example.features.courses.models.Course
import kotlinx.coroutines.flow.Flow

public interface GetFavoriteCoursesUseCase {
    public suspend operator fun invoke(): Flow<List<Course>>
}
