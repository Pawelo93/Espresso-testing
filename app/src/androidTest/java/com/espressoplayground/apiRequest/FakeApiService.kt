package com.espressoplayground.apiRequest

import com.espressoplayground.network.ApiService
import com.espressoplayground.network.Post
import io.reactivex.Single

class FakeApiService : ApiService {
    override fun loadPosts(): Single<List<Post>> {
        return Single.just(listOf(Post(1, 2, "Post title", "Post body")))
    }
}