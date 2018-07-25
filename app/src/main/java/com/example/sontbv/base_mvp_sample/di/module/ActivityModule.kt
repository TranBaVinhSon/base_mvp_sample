package com.example.sontbv.base_mvp_sample.di.module

import android.app.Activity
import com.example.sontbv.base_mvp_sample.ui.main.MainContract
import com.example.sontbv.base_mvp_sample.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}