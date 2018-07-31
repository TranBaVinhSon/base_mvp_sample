package com.example.sontbv.base_mvp_sample.ui.list

import android.util.Log
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.network.ServiceGenerator
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import com.example.sontbv.base_mvp_sample.data.db.model.User
import io.reactivex.observers.DisposableSingleObserver


class ListPresenter: ListContract.Presenter {
    private lateinit var view: ListContract.View
    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun getPhotos() {
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        disposable.add(
                apiInterface!!.getPhotos()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<List<Photo>>(){
                            override fun onSuccess(photos: List<Photo>) {
                                view.getPhotosSuccess(photos)
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