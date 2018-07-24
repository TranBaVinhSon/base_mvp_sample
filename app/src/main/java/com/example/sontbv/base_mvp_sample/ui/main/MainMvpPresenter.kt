package com.example.sontbv.base_mvp_sample.ui.main

import com.example.sontbv.base_mvp_sample.data.db.model.Photo

interface MainMvpPresenter {
    fun getPhotos()
    fun onPhotosLoaded(photos: List<Photo>)
}