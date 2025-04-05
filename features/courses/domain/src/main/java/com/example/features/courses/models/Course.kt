package com.example.features.courses.models

public data class Course(
    public val id: Int,
    public val title: String,
    public val description: String,
    public val price: String,
    public val rating: String,
    public val startDate: String,
    public val isLiked: Boolean,
    public val publishDate: String
)
