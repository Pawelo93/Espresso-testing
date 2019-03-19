package com.espressoplayground.base

import com.espressoplayground.rx.RxTransformer
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestTransformer(
    private val testScheduler: Scheduler = Schedulers.trampoline()
) : RxTransformer {

    override fun computation() = testScheduler

    override fun main() = Schedulers.trampoline()

    override fun io() = Schedulers.trampoline()
}