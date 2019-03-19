package com.espressoplayground.apiRequest

import com.espressoplayground.base.BasePresenter
import com.espressoplayground.rx.RxTransformer
import com.espressoplayground.utils.applySchedulers
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
            }, {
                view?.hideProgressBar()
            })
            .remember()
    }
}