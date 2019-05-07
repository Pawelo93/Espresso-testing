package com.espressoplayground.base.di

import android.content.Context
import com.espressoplayground.base.TestApp
import com.espressoplayground.base.utils.TestTransformer
import com.espressoplayground.main.MainApplication
import com.espressoplayground.rx.RxTransformer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestAppModule {

    @Provides
    fun applicationContext(app: TestApp): Context {
        return app
    }

    @Provides
    @Singleton
    fun rxTransformer(): RxTransformer {
        return TestTransformer()
    }
}