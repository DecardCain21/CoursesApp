package com.example.coursesapp.core.network

import com.example.coursesapp.core.dto.CoursesResponseDto
import retrofit2.http.GET

interface CoursesApiService {
    @GET("DecardCain21/CoursesApp/blob/master/courses.json")
    suspend fun getCourses(
    ): CoursesResponseDto

    companion object {
        const val BASE_URL = "https://github.com/"
    }
}