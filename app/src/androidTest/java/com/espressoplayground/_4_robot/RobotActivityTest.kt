package com.espressoplayground._4_robot

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.espressoplayground.R
import com.espressoplayground.robots.LoginRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RobotActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(RobotActivity::class.java)

    @Test
    fun clickLoginReturnsErrorWhenEmptyPassword() {
        login {
            setLogin("Test")
            clickLogin()
            matchErrorText(getResourceString(R.string.empty_password_error))
            isErrorTextVisible()
        }
    }

    @Test
    fun clickLoginOpenNewActivityWhenLoginAndPasswordIsCorrect() {
        login {
            setLogin("Test")
            setPassword("test")
            clickLogin()
            isActivityLaunched(intentsTestRule.activity, NextRobotActivity::class.java)
        }
    }

    private fun login(func: LoginRobot.() -> Unit) = LoginRobot()
        .apply { func() }

    private fun getResourceString(id: Int): String {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        return targetContext.getString(id)
    }
}