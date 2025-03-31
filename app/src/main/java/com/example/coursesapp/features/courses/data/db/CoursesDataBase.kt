package com.example.coursesapp.features.courses.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursesapp.features.courses.data.db.dao.CoursesDao
import com.example.coursesapp.features.courses.data.db.entity.CourseEntity

@Database(
    version = 1,
    entities = [CourseEntity::class]
)
abstract class CoursesDataBase : RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
}