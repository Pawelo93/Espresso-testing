package com.espressoplayground.main

import android.app.Activity
import android.app.Application
import com.espressoplayground.di.DaggerMainAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class MainApplication : Application(), HasActivityInjector {

    @Inject
    open lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerMainAppComponent.factory()
            .create(this)
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}