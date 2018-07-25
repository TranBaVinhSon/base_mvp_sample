package com.example.sontbv.base_mvp_sample.ui.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.widget.SquareImage
import de.hdodenhof.circleimageview.CircleImageView

class ListAdapter(context: Context, photos:List<Photo>): RecyclerView.Adapter<ListAdapter.MainViewHolder>(){
    private val TAG = "ListAdapter"
    private val photos:List<Photo>
    private val context:Context
    init {
        this.context = context
        this.photos = photos
    }

    class MainViewHolder: RecyclerView.ViewHolder {
        var username: TextView
        var photo: SquareImage
        var userAvatar: CircleImageView
        constructor(viewHolder: View): super(viewHolder) {
            username = viewHolder.findViewById(R.id.item_photo_username)
            photo = viewHolder.findViewById(R.id.item_photo_photo)
            userAvatar = viewHolder.findViewById(R.id.item_photo_user_avatar)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        val itemView = LayoutInflater.from(p0.getContext())
                .inflate(R.layout.item_photo, p0, false)
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val photo = photos.get(position)
        holder.username.setText(photo.user.username)
        Log.d(TAG, photo.toString() + "")
        Glide
                .with(context)
                .load(photo.urls.regular)
                .into(holder.photo)
        Glide
                .with(context)
                .load(photo.user.profile_image.small)
                .into(holder.userAvatar)
    }
}