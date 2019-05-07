package com.espressoplayground.di

import com.espressoplayground.main.MainApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityModule::class,
    UtilsModule::class,
    NetworkModule::class,
    AndroidSupportInjectionModule::class
])
interface MainAppComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<MainApplication>
}