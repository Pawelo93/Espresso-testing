package com.espressoplayground.di

import com.espressoplayground.main.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityModule::class,
    NetworkModule::class,
    AndroidSupportInjectionModule::class
])
interface MainAppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(applicatiion: MainApplication): Builder

        fun build(): MainAppComponent
    }

    fun inject(app: MainApplication)
}