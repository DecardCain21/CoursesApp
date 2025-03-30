package com.example.coursesapp.features.home.domain.usecase

import com.example.coursesapp.features.home.data.CoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoursesUseCaseImpl(private val coursesRepository: CoursesRepository) : GetCoursesUseCase {

    override suspend fun invoke() = withContext(Dispatchers.IO) {
        coursesRepository.getCourses()
    }
}