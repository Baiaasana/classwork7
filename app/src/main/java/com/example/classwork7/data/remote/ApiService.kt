package com.example.classwork7.data.remote

import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.utils.Const
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Const.END_POINT)
    suspend fun getInfo(): Response<CourseModel>
}