package com.example.coursesapp.features.courses.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_courses")
data class CourseEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rating: String,
    val startDate: String,
    val isLiked: Boolean,
    val publishDate: String
)