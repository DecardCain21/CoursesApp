package com.example.coursesapp.core.network

import com.example.coursesapp.features.courses.data.dto.CoursesResponseDto
import retrofit2.http.GET

interface CoursesApiService {
    @GET("DecardCain21/CoursesApp/refs/heads/master/courses.json")
    suspend fun getCourses(
    ): CoursesResponseDto

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}
