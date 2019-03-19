package com.espressoplayground.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<View> {

    var view: View? = null
    private val compositeDisposable = CompositeDisposable()

    fun bind(view: View) {
        this.view = view
    }

    fun unbind() {
        view = null
        compositeDisposable.clear()
    }

    protected fun Disposable.remember() {
        compositeDisposable.add(this)
    }
}