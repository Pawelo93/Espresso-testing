package com.espressoplayground.robots

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.espressoplayground.R

class LoginRobot : BaseTestRobot() {

    fun setLogin(login: String) = fillEditText(R.id.loginEditText, login)

    fun setPassword(pass: String) = fillEditText(R.id.passwordEditText, pass)

    fun clickLogin() = clickButton(R.id.loginButton)

    fun matchErrorText(err: String) = matchText(textView(R.id.errorMessageTextView), err)

    fun isErrorTextVisible() = textView(R.id.errorMessageTextView).check(matches(isDisplayed()))

    fun isActivityLaunched() = intending(toPackage("com.android.contacts")).respondWith(result))
}