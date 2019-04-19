package com.espressoplayground._2_apiRequest

import com.espressoplayground.base.BasePresenter
import com.espressoplayground.rx.RxTransformer
import com.espressoplayground.base.utils.applySchedulers
import javax.inject.Inject

class ApiRequestPresenter @Inject constructor(
    private val getOnePostUseCase: GetOnePostUseCase,
    private val rxTransformer: RxTransformer
) : BasePresenter<ApiRequestView>() {

    fun makeApiCall() {
        getOnePostUseCase()
            .applySchedulers(rxTransformer)
            .subscribe({
                view?.showPost(it)
                view?.hideProgressBar()
            }, {
                view?.hideProgressBar()
                view?.showErrorMessage(it.message ?: "")
            })
            .remember()
    }
}