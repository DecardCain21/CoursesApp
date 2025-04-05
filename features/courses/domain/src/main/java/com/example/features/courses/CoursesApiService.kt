package com.example.features.courses

import com.example.features.courses.dto.CoursesResponseDto
import retrofit2.http.GET

internal interface CoursesApiService {
    @GET("DecardCain21/CoursesApp/refs/heads/master/courses.json")
    suspend fun getCourses(): CoursesResponseDto
}
