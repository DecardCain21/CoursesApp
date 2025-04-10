package com.example.features.courses.usecase

import com.example.features.courses.models.Course

public interface AddFavoriteCourseUseCase {
   public suspend operator fun invoke(course: Course)
}
