package com.example.features.courses.dto

import com.google.gson.annotations.SerializedName

public class CoursesResponseDto(
    @SerializedName("courses")
    public val courses: List<CourseDto>
)

public class CourseDto(
    @SerializedName("id")
    public val id: Int,

    @SerializedName("title")
    public val title: String,

    @SerializedName("text")
    public val description: String,

    @SerializedName("price")
    public val price: String,

    @SerializedName("rate")
    public val rating: String,

    @SerializedName("startDate")
    public val startDate: String,

    @SerializedName("hasLike")
    public val isLiked: Boolean,

    @SerializedName("publishDate")
    public val publishDate: String
)
