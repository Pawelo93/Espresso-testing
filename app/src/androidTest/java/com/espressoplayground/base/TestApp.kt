package com.espressoplayground.base

import com.espressoplayground.main.MainApplication

class TestApp : MainApplication() {

    override fun onCreate() {
        super.onCreate()
        DaggerTestAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}