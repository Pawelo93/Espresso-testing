package com.espressoplayground.robots

import android.content.ComponentName
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.espressoplayground.R
import com.espressoplayground._3_openActivity.SecondActivity

class LoginRobot : BaseTestRobot() {

    fun setLogin(login: String) = fillEditText(R.id.loginEditText, login)

    fun setPassword(pass: String) = fillEditText(R.id.passwordEditText, pass)

    fun clickLogin() = clickButton(R.id.loginButton)

    fun matchErrorText(err: String) = matchText(textView(R.id.errorMessageTextView), err)

    fun isErrorTextVisible() = textView(R.id.errorMessageTextView).check(matches(isDisplayed()))

//    fun isActivityLaunched() = intending(
//        hasComponent(ComponentName(intentsTestRule.activity, SecondActivity::class.java))
//    )
}