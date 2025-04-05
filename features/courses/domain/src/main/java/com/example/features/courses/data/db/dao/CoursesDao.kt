package com.example.features.courses.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.features.courses.data.db.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
public interface CoursesDao {
    @Insert
    public suspend fun add(course: CourseEntity)

    @Query("SELECT*FROM favorite_courses ORDER BY publishDate DESC")
    public fun getAll(): Flow<List<CourseEntity>>
}