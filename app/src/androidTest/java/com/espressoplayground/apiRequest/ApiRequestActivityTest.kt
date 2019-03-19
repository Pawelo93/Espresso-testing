package com.espressoplayground.apiRequest

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.espressoplayground.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApiRequestActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(ApiRequestActivity::class.java)

    @Test
    fun getPostSuccess() {
        onView(withId(R.id.titleTextView))
            .check(matches(withText("Post title")))

        onView(withId(R.id.bodyTextView))
            .check(matches(withText("Post body")))
    }
}