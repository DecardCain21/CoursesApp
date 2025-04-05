package com.example.features.courses.data.convertor

import com.example.features.courses.dto.CourseDto
import com.example.features.courses.dto.CoursesResponseDto
import com.example.features.courses.models.Course

public fun CoursesResponseDto.convertToList(): List<Course> {
    return courses.map { courseDto -> courseDto.convertToCourse() }
}


public fun CourseDto.convertToCourse(): Course = Course(
    id = id,
    title = title,
    description = description,
    price = price,
    rating = rating,
    publishDate = publishDate,
    startDate = startDate,
    isLiked = isLiked
)
