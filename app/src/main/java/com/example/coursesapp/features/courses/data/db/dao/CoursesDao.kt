package com.example.coursesapp.features.courses.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coursesapp.features.courses.data.db.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoursesDao {
    @Insert
    suspend fun add(course: CourseEntity)

    @Query("SELECT*FROM favorite_courses ORDER BY publishDate DESC")
    fun getAll(): Flow<List<CourseEntity>>
}