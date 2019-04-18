package com.espressoplayground.simpleAsync

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.espressoplayground.R
import com.espressoplayground.apiRequest.ApiRequestActivity
import com.espressoplayground.base.TestApp
import dagger.android.AndroidInjector
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleAsyncActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(SimpleAsyncActivity::class.java)

    @Test
    fun showTextAfterClickInTheButton() {
        onView(withId(R.id.button))
            .perform(click())

        onView(withId(R.id.textView))
            .check(matches(isDisplayed()))
    }
}