package com.espressoplayground.apiRequest

import com.espressoplayground.base.BasePresenter
import com.espressoplayground.rx.RxTransformer
import com.espressoplayground.utils.applySchedulers
import javax.inject.Inject

open class ApiRequestPresenter @Inject constructor(
    private val getOnePostUseCase: GetOnePostUseCase,
    private val rxTransformer: RxTransformer
) : BasePresenter<ApiRequestView>() {

    open fun makeApiCall() {
        getOnePostUseCase()
            .applySchedulers(rxTransformer)
            .subscribe({
                view?.showPost(it)
            }, {
                view?.hideProgressBar()
                view?.showErrorMessage(it.message ?: "")
            })
            .remember()
    }
}