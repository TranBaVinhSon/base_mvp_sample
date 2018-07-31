package com.example.sontbv.base_mvp_sample.network

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>

    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: String): Single<Photo>
}