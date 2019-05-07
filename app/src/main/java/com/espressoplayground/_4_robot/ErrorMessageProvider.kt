package com.espressoplayground._4_robot

import android.content.res.Resources
import com.espressoplayground.R
import javax.inject.Inject

class ErrorMessageProvider @Inject constructor(
    private val resources: Resources
) {

    fun getEmptyPasswordError() = resources.getString(R.string.empty_password_error)
}