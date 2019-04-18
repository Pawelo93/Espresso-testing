package com.espressoplayground.base

import android.app.Activity
import com.espressoplayground.main.MainApplication
import dagger.android.AndroidInjector

class TestApp : MainApplication() {

    lateinit var injector: AndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerTestAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = injector
}