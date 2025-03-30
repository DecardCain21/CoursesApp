package com.example.coursesapp.features.home.data

import com.example.coursesapp.features.home.domain.items.Course

interface CoursesRepository {
    suspend fun getCourses(): Result<List<Course>>
}