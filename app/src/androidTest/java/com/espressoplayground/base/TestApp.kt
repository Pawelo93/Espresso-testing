package com.espressoplayground.base

import android.app.Activity
import com.espressoplayground.base.di.DaggerTestAppComponent
import com.espressoplayground.main.MainApplication
import dagger.android.AndroidInjector

class TestApp : MainApplication() {

    lateinit var injector: AndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerTestAppComponent.factory()
            .create(this)
            .inject(this)
    }

    override fun activityInjector() = if(::injector.isInitialized) injector else activityInjector
}