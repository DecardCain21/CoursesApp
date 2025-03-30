package com.example.coursesapp.core.network.client

import com.example.coursesapp.core.dto.CoursesResponseDto
import com.example.coursesapp.core.network.CoursesApiService
import com.example.coursesapp.core.network.RetrofitNetworkClient

class CoursesNetworkClient(
    private val apiService: CoursesApiService
) : RetrofitNetworkClient() {

    suspend fun getCourses(): Result<CoursesResponseDto> {
        return super.doRequest {
            apiService.getCourses()
        }
    }


}