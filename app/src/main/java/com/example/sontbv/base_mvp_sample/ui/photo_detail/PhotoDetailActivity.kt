package com.example.sontbv.base_mvp_sample.ui.photo_detail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.di.component.DaggerPhotoDetailActivityComponent
import com.example.sontbv.base_mvp_sample.di.module.PhotoDetailActivityModule
import kotlinx.android.synthetic.main.activity_photo_detail.*
import javax.inject.Inject

class PhotoDetailActivity: AppCompatActivity(), PhotoDetailContract.View {

    @Inject lateinit var presenter: PhotoDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        var photoId: String = intent.getStringExtra("photoId")

        injectDependency()
        presenter.attach(this)
        initView(photoId)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressbar.visibility = View.GONE
            activity_photo_detail_photo.visibility = View.VISIBLE
        } else {
            progressbar.visibility = View.VISIBLE
            activity_photo_detail_photo.visibility = View.GONE
        }
    }

    private fun initView(photoId: String){
        presenter.getPhoto(photoId)
        showProgress(true)
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun getPhotoSuccess(photo: Photo) {
        activity_photo_detail_username.setText(photo.user.username)
        Glide
                .with(applicationContext)
                .load(photo.urls.regular)
                .into(activity_photo_detail_photo)
        Glide
                .with(applicationContext)
                .load(photo.user.profile_image.small)
                .into(activity_photo_detail_user_avatar)
    }

    private fun injectDependency() {
        val activityComponent = DaggerPhotoDetailActivityComponent.builder()
                .photoDetailActivityModule(PhotoDetailActivityModule(this))
                .build()

        activityComponent.inject(this)
    }
}