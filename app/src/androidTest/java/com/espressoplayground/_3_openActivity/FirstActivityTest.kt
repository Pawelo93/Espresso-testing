package com.espressoplayground._3_openActivity

import android.content.ComponentName
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.espressoplayground.R
import org.junit.Rule
import org.junit.Test

class FirstActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(FirstActivity::class.java)

    @Test
    fun openSecondActivity() {
        onView(withId(R.id.openSecondActivityButton))
            .perform(click())
        intended(hasComponent(ComponentName(intentsTestRule.activity, SecondActivity::class.java)))
    }

    @Test
    fun openSecondActivityWithProperUserName() {
        onView(withId(R.id.openSecondActivityButton))
            .perform(click())
        intended(hasComponent(ComponentName(intentsTestRule.activity, SecondActivity::class.java)))
        intended(hasExtra("name", "Wacek"))
    }
}