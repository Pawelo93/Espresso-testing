package com.espressoplayground._3_openActivity

import android.content.ComponentName
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.espressoplayground.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
        val name = "Wacek"
        onView(withId(R.id.nameEditText))
            .perform(typeText(name))
        onView(withId(R.id.openSecondActivityButton))
            .perform(click())
        intended(hasComponent(ComponentName(intentsTestRule.activity, SecondActivity::class.java)))
        intended(hasExtra(FirstActivity.NAME_EXTRA, name))
    }
}