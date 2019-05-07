package com.espressoplayground._4_robot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.espressoplayground.R
import com.espressoplayground.robots.LoginRobot
import org.junit.Rule
import org.junit.Test

class RobotActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(RobotActivity::class.java)

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
            isRobot2ActivityOpened()
        }
    }

    private fun login(func: LoginRobot.() -> Unit) = LoginRobot()
        .apply { func() }

    private fun getResourceString(id: Int): String {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        return targetContext.getString(id)
    }
}