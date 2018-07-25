package com.example.sontbv.base_mvp_sample.ui.list

import android.support.v4.app.Fragment
import android.view.View
import javax.inject.Inject

class ListFragment: Fragment(), ListContract.View, ListAdapter.onItemClickListener {

    @Inject lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun hideProgressBar() {
        progressbar.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
    }

    override fun setPhotos(photos: List<Photo>) {
        var adapter = ListAdapter(applicationContext, photos)
        recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        view.showProgressBar()
        getPhotos()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onResponseFailure(throwable: Throwable) {
    }

    companion object {
        val TAG: String = "ListFragment"
    }
}