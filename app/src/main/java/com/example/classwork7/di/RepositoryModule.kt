package com.example.classwork7.di

import com.example.classwork7.domain.repository.Repository
import com.example.classwork7.data.repository.CourseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        factsRepository: CourseRepositoryImpl,
    ): Repository
}