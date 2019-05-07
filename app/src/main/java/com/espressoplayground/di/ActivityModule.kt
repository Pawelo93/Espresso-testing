package com.espressoplayground.di

import com.espressoplayground._2_apiRequest.ApiRequestActivity
import com.espressoplayground.main.MainActivity
import com.espressoplayground._1_simpleAsync.SimpleAsyncActivity
import com.espressoplayground._4_robot.RobotActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindSimpleAsyncActivity(): SimpleAsyncActivity

    @ContributesAndroidInjector
    fun bindApiRequestActivity(): ApiRequestActivity

    @ContributesAndroidInjector
    fun bindRobotActivity(): RobotActivity
}