package com.espressoplayground._2_apiRequest

import com.espressoplayground.network.ApiService
import com.espressoplayground.network.Post
import io.reactivex.Single
import javax.inject.Inject

class GetOnePostUseCase @Inject constructor(
    private val apiService: ApiService
) {

    operator fun invoke(): Single<Post> {
        return apiService.loadPosts()
            .map { it.first() }
    }
}