package com.espressoplayground.simpleAsync

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.espressoplayground.R
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