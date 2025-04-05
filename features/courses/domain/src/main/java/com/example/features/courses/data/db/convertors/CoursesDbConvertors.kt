package com.example.features.courses.data.db.convertors

import com.example.features.courses.data.db.entity.CourseEntity
import com.example.features.courses.models.Course

public fun Course.convertToEntity(): CourseEntity =
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

public fun CourseEntity.convertToCourse(): Course =
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
