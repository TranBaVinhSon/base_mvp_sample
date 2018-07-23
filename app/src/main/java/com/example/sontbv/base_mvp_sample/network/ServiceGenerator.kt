package com.example.sontbv.base_mvp_sample.network

import com.example.sontbv.base_mvp_sample.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceGenerator {
    // like static in java
    companion object {
        var retrofit: Retrofit? = null
        var httpLoggingInterceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        // TODO: Add header here
        var okHttpClientBuilder: OkHttpClient.Builder? = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
        var okHttpClient: OkHttpClient? = okHttpClientBuilder?.build()

        fun <T> createService(serviceClass: Class<T> ): T? {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(Constants.BASE_API_URL)
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()
            }
            return retrofit?.create(serviceClass)
        }
    }
}