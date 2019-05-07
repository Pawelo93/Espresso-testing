package com.espressoplayground._4_robot

import com.espressoplayground.base.BasePresenter
import javax.inject.Inject

class RobotPresenter @Inject constructor(
    private val emptyMessageProvider: ErrorMessageProvider
) : BasePresenter<RobotView>() {

    fun login(login: String, password: String) {
        if(login.isEmpty() || password.isEmpty())
            view?.showError(emptyMessageProvider.getEmptyPasswordError())
        else
            view?.openNextRobotActivity()
    }
}