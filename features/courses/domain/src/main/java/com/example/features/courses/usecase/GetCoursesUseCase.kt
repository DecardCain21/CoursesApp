package com.example.features.courses.usecase

import com.example.features.courses.models.Course

public interface GetCoursesUseCase {
    public suspend operator fun invoke(): Result<List<Course>>
}
