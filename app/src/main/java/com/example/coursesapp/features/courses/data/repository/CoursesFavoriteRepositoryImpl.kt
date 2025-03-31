package com.example.coursesapp.features.courses.data.repository

import com.example.coursesapp.features.courses.data.db.CoursesDataBase
import com.example.coursesapp.features.courses.data.db.convertors.convertToCourse
import com.example.coursesapp.features.courses.data.db.convertors.convertToEntity
import com.example.coursesapp.features.courses.domain.api.CoursesFavoriteRepository
import com.example.coursesapp.features.courses.domain.models.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoursesFavoriteRepositoryImpl(
    private val coursesDataBase: CoursesDataBase
) : CoursesFavoriteRepository {
    override suspend fun saveCourseInDb(course: Course) {
        coursesDataBase.coursesDao().add(course.convertToEntity())
    }

    override fun getAll(): Flow<List<Course>> {
        return coursesDataBase.coursesDao().getAll()
            .map { listItems -> listItems.map { it.convertToCourse() } }
    }
}