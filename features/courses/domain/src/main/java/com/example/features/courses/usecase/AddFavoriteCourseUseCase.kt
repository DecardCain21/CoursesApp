package com.example.features.courses.usecase

import com.example.features.courses.models.Course

interface AddFavoriteCourseUseCase {
   suspend operator fun invoke(course: Course)
}
