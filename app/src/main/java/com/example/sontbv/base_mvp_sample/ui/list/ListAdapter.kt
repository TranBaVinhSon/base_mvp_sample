package com.example.sontbv.base_mvp_sample.ui.list

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sontbv.base_mvp_sample.R
import com.example.sontbv.base_mvp_sample.data.db.model.Photo
import com.example.sontbv.base_mvp_sample.ui.photo_detail.PhotoDetailActivity
import com.example.sontbv.base_mvp_sample.widget.SquareImage
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class ListAdapter(): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private lateinit var listener: ListAdapter.onItemClickListener
    private lateinit var photos: MutableList<Photo>
    private lateinit var context: Context
    private val TAG = "ListAdapter"

    constructor(context: Context, photos: MutableList<Photo>,
                fragment: Fragment) : this() {
        this.listener = fragment as onItemClickListener
        this.context = context
        this.photos = photos
    }

    class ListViewHolder(viewHolder: View) :RecyclerView.ViewHolder(viewHolder) {
        var username: TextView = viewHolder.findViewById(R.id.item_photo_username)
        var photo: SquareImage = viewHolder.findViewById(R.id.item_photo_photo)
        var userAvatar: CircleImageView = viewHolder.findViewById(R.id.item_photo_user_avatar)
        var itemLayout: FrameLayout = viewHolder.findViewById(R.id.item_photo_layout)

        fun bind(item: Photo) {
            username.text = item.user.username
        }
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
        val photo = photos[position]
        holder.bind(photo)
        holder.itemLayout.setOnClickListener {
            listener.itemDetail(photo.id)
        }
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