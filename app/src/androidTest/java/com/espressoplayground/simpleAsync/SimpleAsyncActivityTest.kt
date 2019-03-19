package com.espressoplayground.simpleAsync

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
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