package com.example.coursesapp.core.network

interface NetworkClient {
    suspend fun <T> doRequest(request: suspend () -> T): Result<T>
}