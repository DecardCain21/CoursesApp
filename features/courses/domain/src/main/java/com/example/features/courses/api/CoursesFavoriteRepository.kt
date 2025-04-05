package com.example.features.courses.api

import com.example.features.courses.models.Course
import kotlinx.coroutines.flow.Flow

public interface CoursesFavoriteRepository {
    public suspend fun saveCourseInDb(course: Course)

    public fun getAll(): Flow<List<Course>>
}
