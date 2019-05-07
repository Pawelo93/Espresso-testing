package com.espressoplayground._4_robot

import com.espressoplayground.base.BasePresenter
import javax.inject.Inject

class RobotPresenter @Inject constructor(
    private val emptyMessageProvider: ErrorMessageProvider
) : BasePresenter<RobotView>() {

    fun login(login: String, password: String) {
        view?.showError(emptyMessageProvider.getEmptyPasswordError())
    }
}