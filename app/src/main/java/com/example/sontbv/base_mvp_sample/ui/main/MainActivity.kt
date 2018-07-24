package com.example.sontbv.base_mvp_sample.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView{

    private val presenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun showProgressBar() {
        progressbar.visibility = View.VISIBLE
        recyclerview.visibility = View.GONE
    }

    override fun hideProgressBar() {
        progressbar.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
    }

    override fun setPhotos(photos: List<Photo>) {
        var adapter = MainAdapter(applicationContext, photos)
        recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onResponseFailure(throwable: Throwable) {
    }
}
