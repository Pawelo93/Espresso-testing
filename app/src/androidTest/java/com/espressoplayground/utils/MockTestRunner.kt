package com.espressoplayground.utils

import android.app.Application
import android.content.Context
import android.os.StrictMode
import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.espressoplayground.base.TestApp

class MockTestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(arguments)
    }

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}