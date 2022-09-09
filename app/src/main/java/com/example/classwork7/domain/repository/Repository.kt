package com.example.classwork7.domain.repository

import com.example.classwork7.utils.Resource
import com.example.classwork7.domain.model.CourseModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun doNetworkCall(): Flow<Resource<CourseModel>>
}