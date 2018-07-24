package com.example.sontbv.base_mvp_sample.ui.main

import com.example.sontbv.base_mvp_sample.data.db.model.Photo

interface MainView {
    fun showProgressBar()
    fun hideProgressBar()
    fun setPhotos(photos: List<Photo>)
    fun onResponseFailure(throwable: Throwable)
}