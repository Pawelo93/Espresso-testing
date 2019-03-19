package com.espressoplayground.base

import android.content.Context
import com.espressoplayground.main.MainApplication
import com.espressoplayground.rx.RxTransformer
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import javax.inject.Singleton

@Module
class TestAppModule {

    @Provides
    fun applicationContext(app: MainApplication): Context {
        return app
    }

    @Provides
    @Singleton
    fun rxTransformer(): RxTransformer {
        return TestTransformer()
    }
}