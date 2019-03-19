package com.espressoplayground.base

import com.espressoplayground.di.ActivityModule
import com.espressoplayground.di.MainAppComponent
import com.espressoplayground.di.NetworkModule
import com.espressoplayground.main.MainApplication
import com.espressoplayground.simpleAsync.SimpleAsyncActivityTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    TestNetworkModule::class,
    ActivityModule::class,
    AndroidSupportInjectionModule::class
])
interface TestAppComponent : MainAppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(applicatiion: MainApplication): Builder

        fun build(): TestAppComponent
    }

    override fun inject(app: MainApplication)

    fun inject(simpleAsyncActivityTest: SimpleAsyncActivityTest)
}