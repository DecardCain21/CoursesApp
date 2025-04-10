package com.example.features.courses.data.repository

import com.example.features.courses.api.CoursesRepository
import com.example.features.courses.client.CoursesNetworkClient
import com.example.features.courses.models.Course

public class CoursesRepositoryImpl(
    private val coursesNetworkClient: CoursesNetworkClient
) : CoursesRepository {
    override suspend fun getCourses(): Result<List<Course>> {
        return coursesNetworkClient.getCourses().map { it }
    }

}
