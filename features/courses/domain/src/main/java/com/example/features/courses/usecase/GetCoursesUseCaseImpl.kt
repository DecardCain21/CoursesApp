package com.example.features.courses.usecase

import com.example.features.courses.api.CoursesRepository
import com.example.features.courses.models.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class GetCoursesUseCaseImpl(private val coursesRepository: CoursesRepository) :
    GetCoursesUseCase {

    override suspend fun invoke(): Result<List<Course>> = withContext(Dispatchers.IO) {
        coursesRepository.getCourses()
    }
}