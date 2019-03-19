package com.espressoplayground.base

import com.espressoplayground.apiRequest.FakeApiService
import com.espressoplayground.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestNetworkModule {

    @Provides
    @Singleton
    fun apiService(): ApiService {
        return FakeApiService()
    }
}