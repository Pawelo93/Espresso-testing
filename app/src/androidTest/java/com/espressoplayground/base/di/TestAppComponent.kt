package com.espressoplayground.base.di

import com.espressoplayground.base.TestApp
import com.espressoplayground.di.ActivityModule
import com.espressoplayground.di.UtilsModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    TestNetworkModule::class,
    UtilsModule::class,
    ActivityModule::class,
    AndroidSupportInjectionModule::class
])
interface TestAppComponent : AndroidInjector<TestApp>  {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<TestApp>
}