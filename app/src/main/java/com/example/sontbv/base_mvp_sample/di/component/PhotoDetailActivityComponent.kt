package com.example.sontbv.base_mvp_sample.di.component

import com.example.sontbv.base_mvp_sample.di.module.PhotoDetailActivityModule
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailActivity
import dagger.Component

@Component(modules = arrayOf(PhotoDetailActivityModule::class))
interface PhotoDetailActivityComponent {

    fun inject(photoDetailActivity: PhotoDetailActivity)

}