package com.example.coursesapp.core.dto

import com.google.gson.annotations.SerializedName

class CoursesResponseDto(
    @SerializedName("courses")
    val courses: List<CourseDto>
)

class CourseDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("text")
    val description: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("rate")
    val rating: String,

    @SerializedName("startDate")
    val startDate: String,

    @SerializedName("hasLike")
    val isLiked: Boolean,

    @SerializedName("publishDate")
    val publishDate: String
)