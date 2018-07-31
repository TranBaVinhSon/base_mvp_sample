package com.example.sontbv.base_mvp_sample.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
        fun onStop()
    }

    interface View
}