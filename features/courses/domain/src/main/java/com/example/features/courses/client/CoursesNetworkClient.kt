package com.example.features.courses.client

import com.example.core.network.RetrofitNetworkClient
import com.example.features.courses.CoursesApiService
import com.example.features.courses.dto.CourseDto
import com.example.features.courses.dto.CoursesResponseDto
import com.example.features.courses.models.Course

public interface CoursesNetworkClient {
    public suspend fun getCourses(): Result<List<Course>>
}

internal class CoursesNetworkClientImpl(
    private val apiService: CoursesApiService
) : RetrofitNetworkClient(), CoursesNetworkClient {

    override suspend fun getCourses(): Result<List<Course>> {
        return super.doRequest {
            apiService.getCourses()
                .courses.map {  it.convertToCourse()/* TODO Map to Course */ }
        }
    }

    fun CoursesResponseDto.convertToList(): List<Course> {
        return courses.map { courseDto -> courseDto.convertToCourse() }
    }


    fun CourseDto.convertToCourse(): Course = Course(
        id = id,
        title = title,
        description = description,
        price = price,
        rating = rating,
        publishDate = publishDate,
        startDate = startDate,
        isLiked = isLiked
    )
}
