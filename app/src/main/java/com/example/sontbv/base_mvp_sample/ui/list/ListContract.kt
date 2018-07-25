package com.example.sontbv.base_mvp_sample.ui.list

import com.example.sontbv.base_mvp_sample.ui.base.BaseContract

class ListContract {
    interface View : BaseContract.View {
        fun hideProgressBar(show: Boolean)
        fun setPhotos(error: String)
        fun loadDataSuccess(list: List<Post>)
        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: Post)
    }
}
