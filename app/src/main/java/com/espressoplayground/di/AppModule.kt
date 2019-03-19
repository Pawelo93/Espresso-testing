package com.espressoplayground.di

import android.content.Context
import com.espressoplayground.main.MainApplication
import com.espressoplayground.rx.IOTransformer
import com.espressoplayground.rx.RxTransformer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule {

    @Provides
    fun applicationContext(app: MainApplication): Context {
        return app
    }

    @Provides
    @Singleton
    fun rxTransformer(): RxTransformer {
        return IOTransformer()
    }
}