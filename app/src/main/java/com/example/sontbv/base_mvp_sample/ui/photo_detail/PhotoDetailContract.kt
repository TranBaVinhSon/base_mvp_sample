package com.example.sontbv.base_mvp_sample.ui.photo_detail

import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.ui.base.BaseContract

class PhotoDetailContract {
    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun getPhotoSuccess(photo: Photo)
    }

    interface Presenter: BaseContract.Presenter<View>{
        fun getPhoto(id: String)
    }
}