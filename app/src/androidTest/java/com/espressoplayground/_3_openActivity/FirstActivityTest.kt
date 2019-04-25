package com.espressoplayground._3_openActivity

import android.content.ComponentName
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FirstActivityTest {

    @get:Rule
    var activityRule = IntentsTestRule(FirstActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun openSecondActivity() {
//        onView(withId(R.id.openSecondActivityButton))
//            .perform(click())
//            .check()
        intended(hasComponent(ComponentName(activityRule.activity, SecondActivity::class.java)))

    }
}