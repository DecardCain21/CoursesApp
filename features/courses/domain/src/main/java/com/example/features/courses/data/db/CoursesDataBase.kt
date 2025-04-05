package com.example.features.courses.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.features.courses.data.db.dao.CoursesDao
import com.example.features.courses.data.db.entity.CourseEntity

@Database(
    version = 1,
    entities = [CourseEntity::class]
)
public abstract class CoursesDataBase : RoomDatabase() {
    public abstract fun coursesDao(): CoursesDao
}