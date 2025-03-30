package com.example.coursesapp.core.convertor

import com.example.coursesapp.core.dto.CourseDto
import com.example.coursesapp.core.dto.CoursesResponseDto
import com.example.coursesapp.features.home.domain.items.Course

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