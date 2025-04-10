package com.example.features.courses.data.repository

import com.example.features.courses.api.CoursesFavoriteRepository
import com.example.features.courses.data.db.CoursesDataBase
import com.example.features.courses.data.db.convertors.convertToCourse
import com.example.features.courses.data.db.convertors.convertToEntity
import com.example.features.courses.models.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

public class CoursesFavoriteRepositoryImpl(
    private val coursesDataBase: CoursesDataBase
) : CoursesFavoriteRepository{
    override suspend fun saveCourseInDb(course: Course) {
        coursesDataBase.coursesDao().add(course.convertToEntity())
    }

    override fun getAll(): Flow<List<Course>> {
        return coursesDataBase.coursesDao().getAll()
            .map { listItems -> listItems.map { it.convertToCourse() } }
    }
}
