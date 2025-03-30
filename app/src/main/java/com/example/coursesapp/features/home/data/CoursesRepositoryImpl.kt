package com.example.coursesapp.features.home.data

import com.example.coursesapp.core.convertor.convertToList
import com.example.coursesapp.core.network.client.CoursesNetworkClient
import com.example.coursesapp.features.home.domain.items.Course

class CoursesRepositoryImpl(
    private val coursesNetworkClient: CoursesNetworkClient
) : CoursesRepository {
    override suspend fun getCourses(): Result<List<Course>> {
        return coursesNetworkClient.getCourses().map { it.convertToList() }
    }

}