package com.example.sontbv.base_mvp_sample.ui.main

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment()
    }
}