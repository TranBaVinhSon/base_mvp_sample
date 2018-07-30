package com.example.sontbv.base_mvp_sample.ui.list

import android.util.Log
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.network.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPresenter: ListContract.Presenter {

    private lateinit var view: ListContract.View

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun getPhotos() {
        var photos: List<Photo>
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        val call = apiInterface!!.getPhotos()
        call.enqueue(object: Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    photos = response.body()!!
                    view.getPhotosSuccess(photos)
                }
                else {
                    view.showErrorMessage(response.message())
                }
                view.showProgress(false)
            }
            override fun onFailure(call: Call<List<Photo>>, t:Throwable) {
                view.showErrorMessage(t.localizedMessage)
            }
        })
    }

}