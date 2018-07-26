package com.example.sontbv.base_mvp_sample.di.module

import com.example.sontbv.base_mvp_sample.network.ApiInterface
import com.example.sontbv.base_mvp_sample.ui.list.ListContract
import com.example.sontbv.base_mvp_sample.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    // Provide another presenter in a same screen
//    @Provides
//    fun provideAboutPresenter(): AboutContract.Presenter {
//        return AboutPresenter()
//    }
}