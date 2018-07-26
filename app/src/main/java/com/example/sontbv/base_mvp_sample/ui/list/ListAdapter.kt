package com.example.sontbv.base_mvp_sample.ui.list

import android.content.Context
import android.support.v4.app.Fragment
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

class ListAdapter(private val context: Context, private val photos: MutableList<Photo>,
                  fragment: Fragment): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val listener: ListAdapter.onItemClickListener

    private val TAG = "ListAdapter"

    init {
        this.listener = fragment as ListAdapter.onItemClickListener
    }

    class ListViewHolder(viewHolder: View) : RecyclerView.ViewHolder(viewHolder) {
        var username: TextView = viewHolder.findViewById(R.id.item_photo_username)
        var photo: SquareImage = viewHolder.findViewById(R.id.item_photo_photo)
        var userAvatar: CircleImageView = viewHolder.findViewById(R.id.item_photo_user_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_photo, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val photo = photos.get(position)
        holder.username.text = photo.user.username
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

    interface onItemClickListener {
        fun itemDetail(photoId : String)
    }
}