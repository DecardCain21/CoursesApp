package com.example.coursesapp.features.courses.data.convertor

import com.example.coursesapp.features.courses.data.dto.CourseDto
import com.example.coursesapp.features.courses.data.dto.CoursesResponseDto
import com.example.coursesapp.features.courses.domain.models.Course

fun CoursesResponseDto.convertToList() =
    courses.map { courseDto -> courseDto.convertToCourse() }


fun CourseDto.convertToCourse() = Course(
    id = id,
    title = title,
    description = description,
    price = price,
    rating = rating,
    publishDate = publishDate,
    startDate = startDate,
    isLiked = isLiked
)
