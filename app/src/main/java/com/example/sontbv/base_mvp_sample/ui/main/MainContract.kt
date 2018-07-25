package com.example.sontbv.base_mvp_sample.ui.main

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<View>
}