package com.espressoplayground.base.di

import com.espressoplayground.di.ActivityModule
import com.espressoplayground.di.MainAppComponent
import com.espressoplayground.main.MainApplication
import com.espressoplayground._1_simpleAsync.SimpleAsyncActivityTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
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