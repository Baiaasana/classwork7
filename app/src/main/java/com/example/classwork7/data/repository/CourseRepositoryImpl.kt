package com.example.classwork7.data.repository

import com.example.classwork7.data.remote.ApiService
import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.domain.repository.Repository
import com.example.classwork7.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val api: ApiService,
) : Repository {

    override suspend fun doNetworkCall(): Flow<Resource<CourseModel>> = flow {
        try {
            emit(Resource.loading(null))
            val response = api.getInfo()
            val result = response.body()!!
            if (response.isSuccessful) {
                emit(Resource.success(result))
            } else {
                emit(Resource.error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.toString()))
        }
    }
}


