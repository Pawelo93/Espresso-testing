package com.espressoplayground.apiRequest

import com.espressoplayground.network.Post

interface ApiRequestView {

    fun showPost(post: Post)
    fun showProgressBar()
    fun hideProgressBar()
}