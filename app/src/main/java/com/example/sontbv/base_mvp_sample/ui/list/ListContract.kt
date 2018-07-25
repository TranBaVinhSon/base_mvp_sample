package com.example.sontbv.base_mvp_sample.ui.list

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.ui.base.BaseContract

class ListContract {
    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun getPhotosSuccess(photos: List<Photo>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getPhotos()
    }
}
