package com.example.classwork7.data.remote

import com.example.classwork7.domain.model.CourseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getInfo() : Response<CourseModel>
}