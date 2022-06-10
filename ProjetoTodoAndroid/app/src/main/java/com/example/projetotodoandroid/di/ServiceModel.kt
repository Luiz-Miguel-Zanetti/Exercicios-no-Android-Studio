package com.example.projetotodoandroid.di

import com.example.projetotodoandroid.model.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModel {

    @Singleton
    @Provides
    fun returnRepository(): Repository{

        return Repository()

    }




}