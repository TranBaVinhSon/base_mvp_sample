package com.example.sontbv.base_mvp_sample.ui.main

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.network.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View

//    fun onResume() {
//        view.showProgressBar()
//        getPhotos()
//    }
//
//    override fun getPhotos() {
//        var photos: List<Photo>
//        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
//        val call = apiInterface!!.getPhotos()
//        call.enqueue(object: Callback<List<Photo>> {
//            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
//                if (response.isSuccessful) {
//                    photos = response.body()!!
//                    onPhotosLoaded(photos)
//                }
//                else {
//                }
//            }
//            override fun onFailure(call: Call<List<Photo>>, t:Throwable) {
//
//            }
//        })
//    }
//
//    override fun onPhotosLoaded(photos: List<Photo>) {
//        view.apply {
//            setPhotos(photos)
//            hideProgressBar()
//        }
//    }

//    fun onDestroy() {
//        view = null
//    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment()
    }
}