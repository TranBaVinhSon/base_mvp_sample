package com.example.sontbv.base_mvp_sample.ui.photo_detail

import android.util.Log
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.network.ServiceGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoDetailPresenter: PhotoDetailContract.Presenter {
    private lateinit var view: PhotoDetailContract.View
    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun attach(view: PhotoDetailContract.View) {
        this.view = view
    }

    override fun getPhoto(id: String) {
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        disposable.add(
                apiInterface!!.getPhoto(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<Photo>(){
                            override fun onSuccess(photo: Photo) {
                                view.getPhotoSuccess(photo)
                                view.showProgress(false)
                            }
                            override fun onError(e: Throwable) {
                                view.showErrorMessage(e.localizedMessage)
                                view.showProgress(false)
                            }
                        })
        )

    }

    override fun onStop() {
        disposable.clear()
    }
}