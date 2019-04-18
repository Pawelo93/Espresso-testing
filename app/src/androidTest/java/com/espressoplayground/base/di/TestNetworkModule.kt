package com.espressoplayground.base.di

import com.espressoplayground.network.ApiService
import com.espressoplayground.network.Post
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import javax.inject.Singleton

@Module
class TestNetworkModule {

    @Provides
    @Singleton
    fun apiService(): ApiService {
        return FakeApiService()
    }
}

class FakeApiService : ApiService {
    override fun loadPosts(): Single<List<Post>> {
        return Single.just(emptyList())
    }
}