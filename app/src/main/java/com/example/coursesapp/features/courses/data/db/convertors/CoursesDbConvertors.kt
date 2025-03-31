package com.example.coursesapp.features.courses.data.db.convertors

import com.example.coursesapp.features.courses.data.db.entity.CourseEntity
import com.example.coursesapp.features.courses.domain.models.Course

fun Course.convertToEntity() =
    CourseEntity(
        id = id,
        title = title,
        description = description,
        price = price,
        rating = rating,
        publishDate = publishDate,
        startDate = startDate,
        isLiked = isLiked
    )

fun CourseEntity.convertToCourse() =
    Course(
        id = id,
        title = title,
        description = description,
        price = price,
        rating = rating,
        publishDate = publishDate,
        startDate = startDate,
        isLiked = isLiked
    )