package com.example.coursesapp.features.courses.domain.api

import com.example.coursesapp.features.courses.domain.models.Course

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Course>>
}