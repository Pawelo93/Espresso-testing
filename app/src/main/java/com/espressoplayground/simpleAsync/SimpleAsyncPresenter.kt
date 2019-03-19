package com.espressoplayground.simpleAsync

import com.espressoplayground.base.BasePresenter
import com.espressoplayground.rx.RxTransformer
import com.espressoplayground.utils.applySchedulers
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SimpleAsyncPresenter @Inject constructor(
    private val rxTransformer: RxTransformer
) : BasePresenter<SimpleAsyncView>() {

    fun doAsyncTask() {
        Single.just("")
            .delay(2000, TimeUnit.MILLISECONDS, rxTransformer.computation())
            .applySchedulers(rxTransformer)
            .subscribe { value, error ->
                val thread = Thread.currentThread()
                println("Thread ${Thread.currentThread()}")
                view?.showResult()
            }.remember()
    }
}