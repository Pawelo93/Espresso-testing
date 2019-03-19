package com.espressoplayground.network

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun loadPosts(): Single<List<Post>>
}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)