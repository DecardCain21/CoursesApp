package com.example.coursesapp.features.courses.domain.usecase

import com.example.coursesapp.features.courses.domain.models.Course

interface GetCoursesUseCase {
    suspend operator fun invoke(): Result<List<Course>>
}