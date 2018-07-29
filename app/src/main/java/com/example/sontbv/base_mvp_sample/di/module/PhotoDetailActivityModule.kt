package com.example.sontbv.base_mvp_sample.di.module

import android.app.Activity
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailContract
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class PhotoDetailActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): PhotoDetailContract.Presenter {
        return PhotoDetailPresenter()
    }

}