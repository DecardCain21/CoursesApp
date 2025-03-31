package com.example.coursesapp.features.courses.domain.api

import com.example.coursesapp.features.courses.domain.models.Course
import kotlinx.coroutines.flow.Flow

interface CoursesFavoriteRepository {
    suspend fun saveCourseInDb(course: Course)

    fun getAll(): Flow<List<Course>>
}