package com.example.features.courses.usecase

import com.example.features.courses.models.Course

interface GetCoursesUseCase {
    suspend operator fun invoke(): Result<List<Course>>
}
