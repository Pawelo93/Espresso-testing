package com.espressoplayground._2_apiRequest

import com.espressoplayground.network.Post

interface ApiRequestView {

    fun showPost(post: Post)
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorMessage(message: String)
}