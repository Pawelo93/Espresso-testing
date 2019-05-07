package com.espressoplayground.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Provides
    @Singleton
    fun resources(context: Context): Resources = context.resources
}