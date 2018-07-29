package com.example.sontbv.base_mvp_sample.network

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{
    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: String): Call<Photo>
}