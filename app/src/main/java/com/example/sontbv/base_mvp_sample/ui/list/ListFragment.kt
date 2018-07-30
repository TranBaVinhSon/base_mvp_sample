package com.example.sontbv.base_mvp_sample.ui.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.di.component.DaggerFragmentComponent
import com.example.sontbv.base_mvp_sample.di.module.FragmentModule
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailActivity
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment: Fragment(), ListContract.View, ListAdapter.onItemClickListener {

    @Inject lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onResume() {
        super.onResume()
        showProgress(true)
        presenter.getPhotos()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        initView()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressbar.visibility = View.GONE
            recyclerview.visibility = View.VISIBLE
        } else {
            progressbar.visibility = View.VISIBLE
            recyclerview.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun getPhotosSuccess(photos: List<Photo>) {
        val adapter = ListAdapter(activity!!, photos.toMutableList(), this)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun itemDetail(photoId: String) {
        val intent = Intent(context, PhotoDetailActivity::class.java)
        intent.putExtra("photoId", photoId)
        context!!.startActivity(intent)
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.getPhotos()
        showProgress(true)
    }

    companion object {
        const val TAG: String = "ListFragment"
    }
}