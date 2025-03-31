package com.example.coursesapp.features.courses.data.repository

import com.example.coursesapp.features.courses.data.convertor.convertToList
import com.example.coursesapp.core.network.client.CoursesNetworkClient
import com.example.coursesapp.features.courses.domain.api.CoursesRepository
import com.example.coursesapp.features.courses.domain.models.Course

class CoursesRepositoryImpl(
    private val coursesNetworkClient: CoursesNetworkClient
) : CoursesRepository {
    override suspend fun getCourses(): Result<List<Course>> {
        return coursesNetworkClient.getCourses().map { it.convertToList() }
    }

}
