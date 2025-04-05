package com.example.features.courses.api

import com.example.features.courses.models.Course

public interface CoursesRepository {
    public suspend fun getCourses(): Result<List<Course>>
}
