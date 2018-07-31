package com.example.sontbv.base_mvp_sample.network

import com.example.sontbv.base_mvp_sample.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


object ServiceGenerator {
    private var retrofit: Retrofit? = null
    private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Client-ID " + Constants.APPLICATION_ID)
                        .build()
                chain.proceed(request)
            }
    private val okHttpClient = okHttpClientBuilder.build()
    fun <T> createService(serviceClass:Class<T>):T? {
        if (retrofit == null)
        {
            retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
        }
        return retrofit?.create(serviceClass)
    }
}