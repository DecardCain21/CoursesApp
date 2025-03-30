package com.example.coursesapp.features.home.domain.usecase

import com.example.coursesapp.features.home.domain.items.Course

interface GetCoursesUseCase {
    suspend operator fun invoke(): Result<List<Course>>
}