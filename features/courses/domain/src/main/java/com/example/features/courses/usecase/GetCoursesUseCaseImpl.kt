package com.example.features.courses.usecase

import com.example.coursesapp.features.courses.domain.api.CoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoursesUseCaseImpl(private val coursesRepository: CoursesRepository) : GetCoursesUseCase {

    override suspend fun invoke() = withContext(Dispatchers.IO) {
        coursesRepository.getCourses()
    }
}