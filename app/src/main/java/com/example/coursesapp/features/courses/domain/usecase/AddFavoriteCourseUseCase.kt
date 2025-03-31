package com.example.coursesapp.features.courses.domain.usecase

import com.example.coursesapp.features.courses.domain.models.Course

interface AddFavoriteCourseUseCase {
   suspend operator fun invoke(course: Course)
}