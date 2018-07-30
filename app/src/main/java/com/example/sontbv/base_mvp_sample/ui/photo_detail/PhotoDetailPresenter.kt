package com.example.sontbv.base_mvp_sample.ui.photo_detail

import android.util.Log
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.network.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoDetailPresenter: PhotoDetailContract.Presenter {
    private lateinit var view: PhotoDetailContract.View

    override fun attach(view: PhotoDetailContract.View) {
        this.view = view
    }

    override fun getPhoto(id: String) {
        var photo: Photo
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        val call = apiInterface!!.getPhoto(id)
        call.enqueue(object: Callback<Photo> {
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                if (response.isSuccessful) {
                    photo = response.body()!!
                    view.getPhotoSuccess(photo)
                }
                else {
                    view.showErrorMessage(response.message())
                }
                view.showProgress(false)
            }
            override fun onFailure(call: Call<Photo>, t:Throwable) {
                view.showErrorMessage(t.localizedMessage)
                view.showProgress(false)
            }
        })


    }
}