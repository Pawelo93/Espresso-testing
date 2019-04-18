package com.espressoplayground.base

import okhttp3.Interceptor
import okhttp3.Response

class BaseUrlChangingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()

//        if (httpUrl != null) {
            original = original.newBuilder()
                .url("http://127.0.0.1:8080/")
                .build()
//        }
        return chain.proceed(original)
    }
}